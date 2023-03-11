package com.practicaltest.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.practicaltest.exception.ZipcodeNullException;
import com.practicaltest.exception.ZipcodeValidateException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.practicaltest.model.Zipcode;
import com.practicaltest.model.ShippingPrice;

public class ShippingPriceService {

    public static ShippingPrice consultZipCode(String zipcode) {
        if(!validZipCode(zipcode)) {
            throw new ZipcodeValidateException();
        } else {
            String url = String.format("https://viacep.com.br/ws/%s/json/", zipcode);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<HashMap> response = restTemplate
                    .exchange(url, HttpMethod.GET, new HttpEntity<>(new String()), HashMap.class);

            if (response.getBody().containsKey("erro")) {
                throw new ZipcodeNullException();
            } else {
                ShippingPrice shippingPrice = new ShippingPrice(
                        new Zipcode(response.getBody().get("cep").toString()),
                        response.getBody().get("logradouro").toString(),
                        response.getBody().get("complemento").toString(),
                        response.getBody().get("bairro").toString(),
                        response.getBody().get("localidade").toString(),
                        response.getBody().get("uf").toString(),
                        calculateShippingPrice(response.getBody().get("uf").toString()));
                return shippingPrice;
            }
        }
    }

    public static boolean validZipCode(String zipcode) {
        if (zipcode.length() == 9 && zipcode.matches("[0-9]{5}-[0-9]{3}")) {
            return true;
        } else if (zipcode.length() == 8 && zipcode.matches("[0-9]{8}")){
            return true;
        }
        return false;
    }

    private static String calculateShippingPrice(String uf) {
        //Nordeste (R$ 15,98), Norte (R$ 20,83).
        //Centro-Oeste (R$ 12,50), Sudeste (R$ 7,85), Sul (R$17,30)

        List<String> nordeste = Arrays.asList("MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA");
        List<String> norte = Arrays.asList("AP", "AM", "PA", "RO", "AC", "RR", "TO");
        List<String> centroOeste = Arrays.asList("GO", "MT", "MS", "DF");
        List<String> sudeste = Arrays.asList("ES", "MG", "RJ", "SP");
        List<String> sul = Arrays.asList("PR", "SC", "RS");

        if(nordeste.contains(uf)) {
            return "15.98";
        } else if(norte.contains(uf)) {
            return "20.83";
        }  else if(centroOeste.contains(uf)) {
            return "12.50";
        }  else if(sudeste.contains(uf)) {
            return "7.85";
        }  else if(sul.contains(uf)) {
            return "17.30";
        }

        return null;

    }

}
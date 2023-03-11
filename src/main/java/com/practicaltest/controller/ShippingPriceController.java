package com.practicaltest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.practicaltest.model.ShippingPrice;
import com.practicaltest.model.Zipcode;
import com.practicaltest.service.ShippingPriceService;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class ShippingPriceController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ShippingPrice consultShippingPrice(@RequestBody Zipcode zipcode) {
        System.out.println(zipcode.getCep());
        return ShippingPriceService.consultZipCode(zipcode.getCep());
    }

}
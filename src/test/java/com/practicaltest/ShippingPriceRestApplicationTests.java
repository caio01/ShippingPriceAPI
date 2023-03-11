package com.practicaltest;

import com.practicaltest.service.ShippingPriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ShippingPriceRestApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCaseValidZipCodeTrue() throws Exception {
        Boolean validZipCodeTrue = ShippingPriceService.validZipCode("01001001");
        Assertions.assertEquals(validZipCodeTrue, true);
    }

    @Test
    void testCaseValidZipCodeTrue2() throws Exception {
        Boolean validZipCodeTrue2 = ShippingPriceService.validZipCode("01001-001");
        Assertions.assertEquals(validZipCodeTrue2, true);
    }

    @Test
    void testCaseValidZipCodeFalse() throws Exception {
        Boolean validZipCodeFalse = ShippingPriceService.validZipCode("010010010");
        Assertions.assertEquals(validZipCodeFalse, false);
    }

    @Test
    void testCaseValidZipCodeFalse2() throws Exception {
        Boolean validZipCodeFalse2 = ShippingPriceService.validZipCode("001001-001");
        Assertions.assertEquals(validZipCodeFalse2, false);
    }

    @Test
    void testCaseValidZipCodeFalse3() throws Exception {
        Boolean validZipCodeFalse2 = ShippingPriceService.validZipCode("a1001-001");
        Assertions.assertEquals(validZipCodeFalse2, false);
    }
    @Test
    void testCaseValidZipCodeFalse4() throws Exception {
        Boolean validZipCodeFalse2 = ShippingPriceService.validZipCode("0100100");
        Assertions.assertEquals(validZipCodeFalse2, false);
    }

    @Test
    void testCasePostZipCode() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/consulta-endereco")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cep\":\"01001001\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(
                        "{\"" +
                                "cep\":\"01001-001\",\"" +
                                "rua\":\"Praça da Sé\"," +
                                "\"complemento\":\"lado par\"," +
                                "\"bairro\":\"Sé\"," +
                                "\"cidade\":\"São Paulo\"," +
                                "\"estado\":\"SP\"," +
                                "\"frete\":\"7.85\"" +
                                "}"
                ));
    }

}
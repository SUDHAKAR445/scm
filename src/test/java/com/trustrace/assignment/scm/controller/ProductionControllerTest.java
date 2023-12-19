package com.trustrace.assignment.scm.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.model.Production;
import com.trustrace.assignment.scm.service.CertificateAgencyService;
import com.trustrace.assignment.scm.service.ProductionService;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(value = ProductionController.class)
public class ProductionControllerTest 
{
     @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductionService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetProductionById() throws Exception {
        String productionID = "AGY001";
        Production c = Production.builder()
                ._id("65464134694494")
                .productionID("AGY001")
                .product("hbfdhu")
                .quantityProduced("Ram")
                .buyerID("ram22@gmail.com")
                .timestamp("5464616346")
                .image_url("jhbuyagf")
                .build();

        given(service.getById(productionID)).willReturn(c);

        ResultActions response = mockMvc.perform(get("/api/agency/{id}",productionID));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$._id").value(c.get_id()))
                .andExpect(jsonPath("$.productionID").value(c.getProductionID()))
                .andExpect(jsonPath("$.product").value(c.getProduct()))
                .andExpect(jsonPath("$.quantityProduced").value(c.getQuantityProduced()))
                .andExpect(jsonPath("$.buyerID").value(c.getBuyerID()))
                .andExpect(jsonPath("$.timestamp").value(c.getTimestamp()))
                .andExpect(jsonPath("$.image_url").value(c.getImage_url())); 
    }

    @Test
    public void getAllProduction() throws Exception
    {
        List<Production> listOfProduction = new ArrayList<>();

        listOfProduction.add( Production.builder()
                ._id("65464134694494")
                .productionID("AGY001")
                .product("hbfdhu")
                .quantityProduced("Ram")
                .buyerID("ram22@gmail.com")
                .timestamp("5464616346")
                .image_url("jhbuyagf")
                .build());
        
        listOfProduction.add( Production.builder()
                ._id("65464134694494")
                .productionID("AGY001")
                .product("hbfdhu")
                .quantityProduced("Ram")
                .buyerID("ram22@gmail.com")
                .timestamp("5464616346")
                .image_url("jhbuyagf")
                .build());
        
        listOfProduction.add( Production.builder()
                ._id("65464134694494")
                .productionID("AGY001")
                .product("hbfdhu")
                .quantityProduced("Ram")
                .buyerID("ram22@gmail.com")
                .timestamp("5464616346")
                .image_url("jhbuyagf")
                .build());
        
        given(service.getAllProduction()).willReturn(listOfProduction);

        ResultActions response = mockMvc.perform(get("/production/getallproduction"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfProduction.size())));
    }
      
}

package com.trustrace.assignment.scm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trustrace.assignment.scm.model.Account;
import com.trustrace.assignment.scm.service.AccountService;

@WebMvcTest(value = AccountController.class)
public class AccountControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean 
    private AccountService accountService;

    @Test
    public void testToGetAccountByBrandId() throws UnsupportedEncodingException, Exception{
        Account acc= Account.builder()
                     .brandid("Brand001")
                     .tier("tier2")
                     .type("brand")
                     .build();
        Mockito.when(accountService.getById(Mockito.anyString())).thenReturn(acc);

        String actualOutput= mockMvc.perform(MockMvcRequestBuilders
                             .get("/account/select/Brand002"))
                             .andExpect(MockMvcResultMatchers.status().isOk())
                             .andReturn()
                             .getResponse()
                             .getContentAsString();
        Account output=new ObjectMapper().readValue(actualOutput, Account.class);

        assertEquals(acc, output);
    }

    @Test
    public void testToCreateAccount() throws UnsupportedEncodingException, Exception{
        Account acc= Account.builder()
                     ._id("y5niifghjk68967")
                     .brandid("B001")
                     .tier("tier2")
                     .type("brand")
                     .build();

        Mockito.when(accountService.saveAccount(Mockito.any(Account.class))).thenReturn("Account saved successfully : "+acc.get_id());
        String result= mockMvc.perform(MockMvcRequestBuilders
                       .post("/account/save")
                       .content(new ObjectMapper().writeValueAsString(acc)).contentType(MediaType.APPLICATION_JSON)
                       )
                       .andExpect(MockMvcResultMatchers.status().isCreated())
                       .andExpect(MockMvcResultMatchers.content().string("Account saved successfully : "+acc.get_id()))
                       .andReturn()
                       .getResponse()
                       .getContentAsString();     
        
        assertEquals("Account saved successfully : y5niifghjk68967",result);
    }
    
}

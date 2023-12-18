package com.trustrace.assignment.scm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trustrace.assignment.scm.exception.MyNotFoundException;
import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.service.CertificateAgencyService;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(value = CertificateAgencyController.class)
public class CertificateAgencyControllerTest 
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CertificateAgencyService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createAgency() throws Exception{
        CertificateAgency c = CertificateAgency.builder()
                ._id("65464134694494")
                .agencyid("AGY001")
                .name("hbfdhu")
                .contactPerson("Ram")
                .emailId("ram22@gmail.com")
                .phone("5464616346")
                .build();
        
        //Mockito.when(service.saveAgency(Mockito.any(CertificateAgency.class))).thenReturn("Agency saved successfully");

        given(service.saveAgency(any(CertificateAgency.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/agency")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(c)));

        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$._id",
                        is(c.get_id())))
                .andExpect(jsonPath("$.agencyid",
                        is(c.getAgencyid())))
                .andExpect(jsonPath("$.name",
                        is(c.getName())))
                .andExpect(jsonPath("$.contactPerson",
                        is(c.getContactPerson())))
                .andExpect(jsonPath("$.emailId",
                        is(c.getEmailId())))
                .andExpect(jsonPath("$.phone",
                        is(c.getPhone())));
        // String result = mockMvc.perform(MockMvcRequestBuilders
        //                 .post("/agency/save").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString("Agency saved successfully"))
        //                 .andExpect(MockMvcResultMatchers.status().isCreated()))
        //                 .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString("Agency saved successfully")))
        //                 .andReturn().getResponse()
        //                 .getContentAsString();

        //                 System.out.println("____________________________");
        //                 System.out.println(result);
        //                 System.out.println("____________________________");

        // CertificateAgency a = objectMapper.readValue(result, CertificateAgency.class);

        // Assertions.assertThat(a).isEqualTo(c);
    }

    @Test
    public void getAllAgency() throws Exception
    {
        List<CertificateAgency> listOfAgency = new ArrayList<>();

        listOfAgency.add(CertificateAgency.builder()
                ._id("6741364685")
                .agencyid("AGY002")
                .name("mjhgnmhv")
                .contactPerson("Sam")
                .emailId("sam45@gmail.com")
                .phone("8587431626")
                .build());
        
        listOfAgency.add(CertificateAgency.builder()
                ._id("65464134694494")
                .agencyid("AGY003")
                .name("hbfdhu")
                .contactPerson("Ram")
                .emailId("ram22@gmail.com")
                .phone("5464616346")
                .build());
        
        listOfAgency.add(CertificateAgency.builder()
                ._id("63258623556")
                .agencyid("AGY004")
                .name("hbfdhu")
                .contactPerson("Ram")
                .emailId("tom45@gmail.com")
                .phone("5464616346")
                .build());
        
        given(service.getAllAgency()).willReturn(listOfAgency);

        ResultActions response = mockMvc.perform(get("/api/agency/getallagency"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfAgency.size())));
    }

    @Test
    public void getAgencyById() throws Exception{
        String agencyid = "AGY001";
        CertificateAgency c = CertificateAgency.builder()
                ._id("65464134694494")
                .agencyid("AGY001")
                .name("hbfdhu")
                .contactPerson("Ram")
                .emailId("ram22@gmail.com")
                .phone("5464616346")
                .build();

        given(service.getById(agencyid)).willReturn(Optional.of(c));

        ResultActions response = mockMvc.perform(get("/api/agency/{id}",agencyid));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$._id",
                        is(c.get_id())))
                .andExpect(jsonPath("$.agencyid",
                        is(c.getAgencyid())))
                .andExpect(jsonPath("$.name",
                        is(c.getName())))
                .andExpect(jsonPath("$.contactPerson",
                        is(c.getContactPerson())))
                .andExpect(jsonPath("$.emailId",
                        is(c.getEmailId())))
                .andExpect(jsonPath("$.phone",
                        is(c.getPhone())));
    }

    @Test
    public void getAgencyByInvalidId() throws Exception{
        String agencyid = "97449";
        CertificateAgency c = CertificateAgency.builder()
                ._id("65464134694494")
                .agencyid("AGY001")
                .name("hbfdhu")
                .contactPerson("Ram")
                .emailId("ram22@gmail.com")
                .phone("5464616346")
                .build();

        given(service.getById(agencyid)).willReturn(Optional.empty());

        ResultActions response = mockMvc.perform(get("/api/agency/{id}",agencyid));

        response.andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void deleteAgencyById() throws Exception{
        String agencyid = "AGY001";

        willDoNothing().given(service).deleteAgency(agencyid);

        ResultActions response = mockMvc.perform(delete("/api/agency/{id}",agencyid));

        response.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void deleteAgencyByInvalidId() throws Exception{

        String invalidAgencyId = "INVALID_ID";
        doThrow(new MyNotFoundException("Agency not found")).when(service).deleteAgency(invalidAgencyId);

        // Act
        ResultActions response = mockMvc.perform(delete("/api/agency/{id}", invalidAgencyId));

        // Assert
        response.andExpect(status().isNotFound())
                .andDo(print());
    }
}
// @WebMvcTest(value = CertificateAgencyController.class)
// public class CertificateAgencyControllerTest {
//     @Autowired
//     MockMvc mockMvc;

//     @MockBean
//     @SpyBean
//     CertificateAgencyService service;

//     @Test
//     void testWhetherClassExists() throws Exception {
//         Mockito.when(service.getById(Mockito.anyString())).thenThrow( (List.of(new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD")));
//         String result = mockMvc.perform(MockMvcRequestBuilders.get("/facilities/select/facilitiesbyId/cd")).andExpect(status().isNotFound()).andReturn().getResponse()
//                 .getContentAsString();
//         System.out.println("_____________________________");
//         System.out.println(result);
//         System.out.println("_____________________________");

//         List<Facilities> op = Arrays.asList(new ObjectMapper().readValue(result, Facilities[].class));
//         // .andReturn().getResponse().getContent;
//         assertFalse(op.isEmpty());

//     }

// }
// }

package com.example.workingwithdatabase.restapi.controller;

import com.example.workingwithdatabase.restapi.model.CloudVendor;
import com.example.workingwithdatabase.restapi.service.CloudVendorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("1","GCP","USA","xxxx");
        cloudVendorTwo = new CloudVendor("2","Amazon","UK","yyyy");
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetAllCloudVendor() throws  Exception{
        when(cloudVendorService.getAllCloudVendor()).thenReturn(cloudVendorList);

        this.mockMvc.perform(get("/cloudvendor")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetCloudVendor() throws  Exception{
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);

        this.mockMvc.perform(get("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateCloudVendor() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.createCloudVendor(cloudVendorOne))
                .thenReturn("Success");
        this.mockMvc.perform(post("/cloudvendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateCloudVendor() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.updateCloudVendor(cloudVendorOne))
                .thenReturn("Success");
        this.mockMvc.perform(put("/cloudvendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteCloudVendor() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1"))
                .thenReturn("Success");
        this.mockMvc.perform(delete("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
    }
}
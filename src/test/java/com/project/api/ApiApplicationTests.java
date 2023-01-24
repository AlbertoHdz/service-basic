package com.project.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.api.controller.ApiController;
import com.project.api.model.Item;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
class ApiApplicationTests {
    
    @Autowired
    ApiController api;
    
    protected MockMvc mvc;

    @Test
    void contextLoads() {
        //Assertions.assertThat(api.getitems()).isNotNull();
        //Assertions.assertThat(api.saveItems(new Item(20,"george","murray"))).isNotNull();
    }
    
    @Test
    public void getItems() throws Exception{
        String uri = "/api/item";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
   
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Item[] productlist = mapFromJson(content, Item[].class);
        assertTrue(productlist.length > 0);
    }
    
    @Test
    public void createItem() throws Exception {
       String uri = "/api/item";
       Item product = new Item(3,"Ginger","Descr");
       
        String inputJson = mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

       int status = mvcResult.getResponse().getStatus();
       assertEquals(201, status);
       String content = mvcResult.getResponse().getContentAsString();
       assertEquals(content, "Product is created successfully");
    }
    
    protected String mapToJson(Object obj) throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(obj);
   }
    
    protected <T> T mapFromJson(String json, Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {
      
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue(json, clazz);
   }

}

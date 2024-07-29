package com.project.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.api.controller.ApiController;
import com.project.api.model.Item;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import static org.hamcrest.Matchers.containsString;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApiApplicationTests {
    
    private final String CREATED = "Product is created successfully";
    
    @Mock
    private ApiController api;
    
    protected MockMvc mockmvc;
    
    @Before
    protected void before(){
        Mockito.when(api.getitems()).thenReturn(itemsTest());
        Mockito.when(api.saveItems(Mockito.any())).thenReturn(CREATED);
    }
    
    @Test
    void contextLoads() throws Exception{
        Assertions.assertThat(api).isNotNull();
        //Assertions.assertThat(api.getitems()).isNotNull();
        //Assertions.assertThat(api.saveItems(new Item(20,"george","murray"))).isNotNull();
    }
    
    @Test
    protected void shouldReturnDefaultMessage(){
        try{
            this.mockmvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
        }catch(Exception e){
            System.err.println("================= ERROR =====================");
            System.err.println(e.getCause());
            System.err.println(e.getLocalizedMessage());
            System.err.println(e);
        }
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

    private String itemsTest() {
        StringBuilder lista = new StringBuilder();
        lista.append(new Item(1,"Jose","description").toString());
        lista.append(new Item(2,"Juan","Segundo").toString());
        lista.append(new Item(10,"Ana","juegos").toString());
       
       return lista.toString();
    }

}

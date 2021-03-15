package com.ppm.zoo.zoo.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class AnimalsRESTTests {
    
    @InjectMocks
    private AnimalsREST metodos = new AnimalsREST();
    
    private MockMvc mockMvc;

    @Before
    public void setup() {
      mockMvc = MockMvcBuilders.standaloneSetup(this.metodos).build();
    }
    @Test
    public void testGetAnimalById(){
        // build your expected results here 
        String url = "http://localhost:8080/animals/1";
        String result = "";
        try {
            MvcResult mvcResult = mockMvc
            .perform(MockMvcRequestBuilders.get(url))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            System.out.println(mvcResult.getResponse());
            result=mvcResult.getResponse().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String responseAsJson = "{\"id\":1,\"nombreComun\":\"León\",\"especie\":\"Panthera leo\",\"grupo\":\"Mamifero\",\"habitat\":\"Sabana\",\"clasificacion\":\"Vertebrado\",\"cantidad\":4,\"acuatico\":false,\"fechaCreacion\":\"2021-03-15T01:29:57.168+00:00\",\"fechaModificacion\":\"2021-03-15T01:29:57.168+00:00\"}"; 

        assertEquals(responseAsJson, result);
    }
}

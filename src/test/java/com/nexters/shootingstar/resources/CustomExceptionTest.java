package com.nexters.shootingstar.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.nexters.shootingstar.exception.CustomException;
import com.nexters.shootingstar.exception.ExceptionDescription;
import com.nexters.shootingstar.models.AccessToken;
import com.nexters.shootingstar.services.jackson.CustomExceptionDeserializer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
public class CustomExceptionTest {

    List<ExceptionDescription> lists;
    CustomException customException;

    /**
     * initialize data
     */
    @Before
    public void init(){
        lists = new ArrayList<ExceptionDescription>();
        customException = new CustomException();
        customException.setStatus(404);
        customException.setType("ClassNotFoundException");

        for(int i=0;i<10;i++)
            lists.add(
                    new ExceptionDescription(
                            "email is null",
                            "email",
                            new AccessToken( UUID.randomUUID().toString() , Integer.toString(i) )
                    )
            );

        customException.setErrors(lists);
    }

    /**
     * interface method test.
     */
    @Test
    public void getClassMethodTest() {

        assertThat( this.getClass().getSimpleName()).isEqualTo("CustomExceptionTest");

    }

    /**
     * serialize by CustomException.
     * @throws Exception The writeValueAsString method of ObjectMapper throws JsonProcessingException .
     */
    @Test
    public void customExceptionSerializerTest() throws Exception{
        System.out.println(new ObjectMapper().writeValueAsString(customException));
    }

    /**
     * deserialize by CustomException.
     * @throws Exception The writeValueAsString method of ObjectMapper throws JsonProcessingException .
     */
    @Test
    public void customExceptionDeserializerTest() throws Exception {
        String json = new ObjectMapper().writeValueAsString(customException);
        System.out.println(json);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(CustomException.class , new CustomExceptionDeserializer());
        System.out.println(new ObjectMapper().registerModule(module).readValue(json,CustomException.class));
    }
    @Test(expected = Exception.class)
    public void wontException()throws Exception {
        
    }

}

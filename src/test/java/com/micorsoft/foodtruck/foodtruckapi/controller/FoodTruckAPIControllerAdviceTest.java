package com.micorsoft.foodtruck.foodtruckapi.controller;

import com.micorsoft.foodtruck.foodtruckapi.error.ErrorResponse;
import com.micorsoft.foodtruck.foodtruckapi.error.FoodTruckAtLocationAlreadyExistsException;
import com.micorsoft.foodtruck.foodtruckapi.error.NoFoodTruckAtBlockException;
import com.micorsoft.foodtruck.foodtruckapi.error.NoFoodTruckAtLocationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class FoodTruckAPIControllerAdviceTest {
    private FoodTruckAPIControllerAdvice foodTruckAPIControllerAdvice = new FoodTruckAPIControllerAdvice();

    @Test
    public void testOnNoFoodTruckAtLocationException() {
        NoFoodTruckAtLocationException noFoodTruckAtLocationException = new NoFoodTruckAtLocationException("123");
        ResponseEntity responseEntity = foodTruckAPIControllerAdvice.onNoFoodTruckAtLocationException(noFoodTruckAtLocationException);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("DATA_NOT_FOUND", ((ErrorResponse) responseEntity.getBody()).getCode());
        assertTrue(((ErrorResponse) responseEntity.getBody()).getMessage().contains("123"));
    }

    @Test
    public void testOnNoFoodTruckAtBlockException() {
        NoFoodTruckAtBlockException noFoodTruckAtBlockException = new NoFoodTruckAtBlockException("123");
        ResponseEntity responseEntity = foodTruckAPIControllerAdvice.onNoFoodTruckAtBlockException(noFoodTruckAtBlockException);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("DATA_NOT_FOUND", ((ErrorResponse) responseEntity.getBody()).getCode());
        assertTrue(((ErrorResponse) responseEntity.getBody()).getMessage().contains("123"));
    }


    @Test
    public void testOnFoodTruckAtLocationAlreadyExistsException() {
        FoodTruckAtLocationAlreadyExistsException foodTruckAtLocationAlreadyExistsException = new FoodTruckAtLocationAlreadyExistsException("123");
        ResponseEntity responseEntity = foodTruckAPIControllerAdvice.onFoodTruckAtLocationAlreadyExistsException(foodTruckAtLocationAlreadyExistsException);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("DATA_ALREADY_EXITS", ((ErrorResponse) responseEntity.getBody()).getCode());
        assertTrue(((ErrorResponse) responseEntity.getBody()).getMessage().contains("123"));
    }
}
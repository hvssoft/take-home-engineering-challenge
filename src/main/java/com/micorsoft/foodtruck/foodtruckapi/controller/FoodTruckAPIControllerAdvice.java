package com.micorsoft.foodtruck.foodtruckapi.controller;

import com.micorsoft.foodtruck.foodtruckapi.error.ErrorResponse;
import com.micorsoft.foodtruck.foodtruckapi.error.FoodTruckAtLocationAlreadyExistsException;
import com.micorsoft.foodtruck.foodtruckapi.error.NoFoodTruckAtBlockException;
import com.micorsoft.foodtruck.foodtruckapi.error.NoFoodTruckAtLocationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FoodTruckAPIControllerAdvice {

    @ExceptionHandler(NoFoodTruckAtLocationException.class)
    public ResponseEntity<ErrorResponse> onNoFoodTruckAtLocationException(NoFoodTruckAtLocationException e) {
        String message = String.format("No food truck found at location %s ", e.getLocationId());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("DATA_NOT_FOUND", message));
    }

    @ExceptionHandler(NoFoodTruckAtBlockException.class)
    public ResponseEntity<ErrorResponse> onNoFoodTruckAtBlockException(NoFoodTruckAtBlockException e) {
        String message = String.format("No food truck found at block %s ", e.getBlock());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("DATA_NOT_FOUND", message));
    }

    @ExceptionHandler(FoodTruckAtLocationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> onFoodTruckAtLocationAlreadyExistsException(FoodTruckAtLocationAlreadyExistsException e) {
        String message = String.format("a Food truck already exits at location  %s ", e.getLocationId());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("DATA_ALREADY_EXITS", message));
    }
}

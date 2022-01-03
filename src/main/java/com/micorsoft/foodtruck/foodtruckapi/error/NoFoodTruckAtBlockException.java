package com.micorsoft.foodtruck.foodtruckapi.error;


import lombok.Getter;

public class NoFoodTruckAtBlockException extends RuntimeException {

    @Getter
    private final String block;

    public NoFoodTruckAtBlockException(String block) {
        this.block = block;
    }
}

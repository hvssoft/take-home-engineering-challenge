package com.micorsoft.foodtruck.foodtruckapi.error;


import lombok.Getter;

public class NoFoodTruckAtLocationException extends RuntimeException {

    @Getter
    private final String locationId;

    public NoFoodTruckAtLocationException(String locationId) {
        this.locationId = locationId;
    }
}

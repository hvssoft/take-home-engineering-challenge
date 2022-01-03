package com.micorsoft.foodtruck.foodtruckapi.error;


import lombok.Getter;

public class FoodTruckAtLocationAlreadyExistsException extends RuntimeException {

    @Getter
    private final String locationId;

    public FoodTruckAtLocationAlreadyExistsException(String locationId) {
        this.locationId = locationId;
    }
}

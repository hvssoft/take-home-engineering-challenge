package com.micorsoft.foodtruck.foodtruckapi.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private final String code;
    private final String message;
}

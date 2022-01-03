package com.micorsoft.foodtruck.foodtruckapi.vo;

import com.micorsoft.foodtruck.foodtruckapi.util.CsvBean;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MobileFoodFacility extends CsvBean {
    @NotNull(message = "locationid cannot be null")
    private String locationid;
    private String applicant;
    private String facilityType;
    private String cnn;
    private String locationDescription;
    @NotNull(message = "address cannot be null")
    private String address;
    private String blocklot;
    @NotNull(message = "block cannot be null")
    private String block;
    private String lot;
    private String permit;
    private String status;
    private String foodItems;
    private String cordinateX;
    private String cordinateY;
    private String latitude;
    private String longitude;
    private String schedule;
    private String dayshours;
    private String noISent;
    private String approved;
    private String received;
    private String priorPermit;
    private String expirationDate;
    private String location;
    private String firePreventionDistricts;
    private String policeDistricts;
    private String supervisorDistricts;
    private String zipCodes;
    private String neighborhoods;
}

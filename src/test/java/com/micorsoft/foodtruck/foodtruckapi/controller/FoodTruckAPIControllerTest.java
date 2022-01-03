package com.micorsoft.foodtruck.foodtruckapi.controller;

import com.micorsoft.foodtruck.foodtruckapi.service.FoodTruckService;
import com.micorsoft.foodtruck.foodtruckapi.vo.MobileFoodFacility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class FoodTruckAPIControllerTest {

    @InjectMocks
    private FoodTruckAPIController foodTruckAPIController;

    @Mock
    private FoodTruckService foodTruckService;

    @Test
    public void testGetMobileFoodFacilitiesByBlockId() {
        List<MobileFoodFacility> expectedReturnList = new ArrayList<>();
        when(foodTruckService.getMobileFoodFacilitiesByBlockId("123")).thenReturn(expectedReturnList);
        List<MobileFoodFacility> actualReturnList = foodTruckAPIController.getMobileFoodFacilitiesByBlockId("123");
        assertEquals(expectedReturnList, actualReturnList);
    }

    @Test
    public void testGetMobileFoodFacilitiesByLocationId() {
        MobileFoodFacility expectedReturn = new MobileFoodFacility();
        when(foodTruckService.getMobileFoodFacilityMapByLocationId("123")).thenReturn(expectedReturn);
        MobileFoodFacility actualReturn = foodTruckAPIController.getMobileFoodFacilitiesByLocationId("123");
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void testAddMobileFoodFacility() {
        MobileFoodFacility expectedReturn = new MobileFoodFacility();
        when(foodTruckService.addMobileFoodFacility(expectedReturn)).thenReturn(expectedReturn);
        MobileFoodFacility actualReturn = foodTruckAPIController.createNewMobileFoodFacility(expectedReturn);
        assertEquals(expectedReturn, actualReturn);
    }

}
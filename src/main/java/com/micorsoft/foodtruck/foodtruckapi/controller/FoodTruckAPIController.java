package com.micorsoft.foodtruck.foodtruckapi.controller;


import com.micorsoft.foodtruck.foodtruckapi.service.FoodTruckService;
import com.micorsoft.foodtruck.foodtruckapi.vo.MobileFoodFacility;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodTruckAPIController {

    private final FoodTruckService foodTruckService;


    @GetMapping("/api/block/{blockId}")
    @ResponseBody
    public List<MobileFoodFacility> getMobileFoodFacilitiesByBlockId(@PathVariable String blockId) {
        return foodTruckService.getMobileFoodFacilitiesByBlockId(blockId);
    }

    @GetMapping("/api/location/{locationId}")
    @ResponseBody
    public MobileFoodFacility getMobileFoodFacilitiesByLocationId(@PathVariable String locationId) {
        return foodTruckService.getMobileFoodFacilityMapByLocationId(locationId);
    }

    @PostMapping("/api")
    public MobileFoodFacility createNewMobileFoodFacility(@RequestBody @Valid MobileFoodFacility mobileFoodFacility) {
        return foodTruckService.addMobileFoodFacility(mobileFoodFacility);
    }
}

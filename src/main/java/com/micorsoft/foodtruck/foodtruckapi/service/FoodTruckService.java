package com.micorsoft.foodtruck.foodtruckapi.service;

import com.micorsoft.foodtruck.foodtruckapi.db.FoodTruckRepository;
import com.micorsoft.foodtruck.foodtruckapi.error.NoFoodTruckAtBlockException;
import com.micorsoft.foodtruck.foodtruckapi.error.NoFoodTruckAtLocationException;
import com.micorsoft.foodtruck.foodtruckapi.util.FoodTruckDBDataLoaderHelper;
import com.micorsoft.foodtruck.foodtruckapi.vo.MobileFoodFacility;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodTruckService {
    private final FoodTruckRepository foodTruckRepository;
    private final FoodTruckDBDataLoaderHelper foodTruckDBDataLoaderHelper;

    public List<MobileFoodFacility> getMobileFoodFacilitiesByBlockId(String blockId) {
        List<MobileFoodFacility> result = foodTruckRepository.getMobileFoodFacilitiesByBlock().get(blockId);
        if (CollectionUtils.isEmpty(result)) {
            throw new NoFoodTruckAtBlockException(blockId);
        }
        return result;
    }

    public MobileFoodFacility getMobileFoodFacilityMapByLocationId(String locationId) {
        MobileFoodFacility mobileFoodFacility = foodTruckRepository.getMobileFoodFacilityMapByLocationId().get(locationId);
        if (mobileFoodFacility == null) {
            throw new NoFoodTruckAtLocationException(locationId);
        }
        return mobileFoodFacility;
    }

    public MobileFoodFacility addMobileFoodFacility(MobileFoodFacility mobileFoodFacility) {
        return foodTruckDBDataLoaderHelper.addMobileFoodFacility(mobileFoodFacility);
    }
}

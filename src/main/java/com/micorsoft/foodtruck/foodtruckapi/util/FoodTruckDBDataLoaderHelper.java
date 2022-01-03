package com.micorsoft.foodtruck.foodtruckapi.util;

import com.micorsoft.foodtruck.foodtruckapi.db.FoodTruckRepository;
import com.micorsoft.foodtruck.foodtruckapi.error.FoodTruckAtLocationAlreadyExistsException;
import com.micorsoft.foodtruck.foodtruckapi.vo.MobileFoodFacility;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Component
@RequiredArgsConstructor
public class FoodTruckDBDataLoaderHelper {

    private final FoodTruckRepository foodTruckRepository;

    public void loadDataToRepo(List<MobileFoodFacility> mobileFoodFacilityList) {
        foodTruckRepository.setMobileFoodFacilityMapByLocationId(mobileFoodFacilityMapByLocationIdLoader(mobileFoodFacilityList));
        foodTruckRepository.setMobileFoodFacilitiesByBlock(mobileFoodFacilitiesByBlock(mobileFoodFacilityList));

    }

    private Map<String, MobileFoodFacility> mobileFoodFacilityMapByLocationIdLoader(List<MobileFoodFacility> mobileFoodFacilityList) {
        Map<String, MobileFoodFacility> returnMap = new HashedMap();
        for (MobileFoodFacility mobileFoodFacility : mobileFoodFacilityList) {
            returnMap.put(mobileFoodFacility.getLocationid(), mobileFoodFacility);
        }
        return returnMap;
    }

    private Map<String, List<MobileFoodFacility>> mobileFoodFacilitiesByBlock(List<MobileFoodFacility> mobileFoodFacilityList) {
        return mobileFoodFacilityList.stream()
                .collect(groupingBy(MobileFoodFacility::getBlock));
    }

    public synchronized MobileFoodFacility addMobileFoodFacility(MobileFoodFacility mobileFoodFacility) {
        if (foodTruckRepository.getMobileFoodFacilityMapByLocationId().get(mobileFoodFacility.getLocationid()) != null) {
            throw new FoodTruckAtLocationAlreadyExistsException(mobileFoodFacility.getLocationid());
        }
        foodTruckRepository.getMobileFoodFacilityMapByLocationId().put(mobileFoodFacility.getLocationid(), mobileFoodFacility);
        List<MobileFoodFacility> mobileFoodFacilities = foodTruckRepository.getMobileFoodFacilitiesByBlock().get(mobileFoodFacility.getBlock());
        if (mobileFoodFacilities == null) {
            mobileFoodFacilities = new ArrayList<>();
        }
        mobileFoodFacilities.add(mobileFoodFacility);
        foodTruckRepository.getMobileFoodFacilitiesByBlock().put(mobileFoodFacility.getBlock(), mobileFoodFacilities);
        return mobileFoodFacility;
    }

}

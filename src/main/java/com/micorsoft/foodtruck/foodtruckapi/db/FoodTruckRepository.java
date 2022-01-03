package com.micorsoft.foodtruck.foodtruckapi.db;

import com.micorsoft.foodtruck.foodtruckapi.vo.MobileFoodFacility;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component

public class FoodTruckRepository {
    @Getter
    @Setter
    private Map<String, MobileFoodFacility> mobileFoodFacilityMapByLocationId;
    @Getter
    @Setter
    private Map<String, List<MobileFoodFacility>> mobileFoodFacilitiesByBlock;


}

package com.micorsoft.foodtruck.foodtruckapi.util;

import com.micorsoft.foodtruck.foodtruckapi.db.FoodTruckRepository;
import com.micorsoft.foodtruck.foodtruckapi.vo.MobileFoodFacility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class FoodTruckDBDataLoaderHelperTest {


    private FoodTruckRepository foodTruckRepository;

    private FoodTruckDBDataLoaderHelper foodTruckDBDataLoaderHelper;


    @Before
    public void init() {
        foodTruckRepository = new FoodTruckRepository();
        foodTruckDBDataLoaderHelper = new FoodTruckDBDataLoaderHelper(foodTruckRepository);

    }

    @Test
    public void testLoadDataToRepo() {
        List<MobileFoodFacility> mobileFoodFacilityList = createMobileFoodFacilityList();
        foodTruckDBDataLoaderHelper.loadDataToRepo(mobileFoodFacilityList);

        MobileFoodFacility mobileFoodFacility1 = foodTruckRepository.getMobileFoodFacilityMapByLocationId().get("1569152");
        assertNotNull(mobileFoodFacility1);
        assertEquals("2535 TAYLOR ST", mobileFoodFacility1.getAddress());

        List<MobileFoodFacility> resultList = foodTruckRepository.getMobileFoodFacilitiesByBlock().get("0029");
        assertEquals(2, resultList.size());
        assertEquals("2535 TAYLOR ST", resultList.get(0).getAddress());
        assertEquals("101 CALIFORNIA ST", resultList.get(1).getAddress());
    }

    private List<MobileFoodFacility> createMobileFoodFacilityList() {
        List<MobileFoodFacility> mobileFoodFacilityList = new ArrayList<>();
        mobileFoodFacilityList.add(createMobileFoodFacility("1569152", "0029", "2535 TAYLOR ST"));
        mobileFoodFacilityList.add(createMobileFoodFacility("1569145", "7283", "Assessors Block 7283/Lot004"));
        mobileFoodFacilityList.add(createMobileFoodFacility("1565593", "0261", "351 CALIFORNIA ST"));
        mobileFoodFacilityList.add(createMobileFoodFacility("1565571", "0029", "101 CALIFORNIA ST"));
        return mobileFoodFacilityList;
    }

    private MobileFoodFacility createMobileFoodFacility(String locationId, String block, String address) {
        MobileFoodFacility mobileFoodFacility = new MobileFoodFacility();
        mobileFoodFacility.setLocationid(locationId);
        mobileFoodFacility.setBlock(block);
        mobileFoodFacility.setAddress(address);
        return mobileFoodFacility;
    }


}
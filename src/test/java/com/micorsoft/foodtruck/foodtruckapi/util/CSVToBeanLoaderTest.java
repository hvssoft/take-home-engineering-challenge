package com.micorsoft.foodtruck.foodtruckapi.util;

import com.micorsoft.foodtruck.foodtruckapi.vo.MobileFoodFacility;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVToBeanLoaderTest {

    private CSVToBeanLoader csvToBeanLoader;

    @Before
    public void init() {
        csvToBeanLoader = new CSVToBeanLoader();
    }

    @Test
    public void testLoadCsvToBean() throws URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("data/Mobile_Food_Facility_Permit.csv").toURI());

        List<MobileFoodFacility> mobileFoodFacilities = (List<MobileFoodFacility>) csvToBeanLoader.loadCsvToBean(path, MobileFoodFacility.class);

        assertEquals(597, mobileFoodFacilities.size());

        assertEquals("1569152", mobileFoodFacilities.get(0).getLocationid());
        assertEquals("0029", mobileFoodFacilities.get(0).getBlock());
        assertEquals("2535 TAYLOR ST", mobileFoodFacilities.get(0).getAddress());

    }

}
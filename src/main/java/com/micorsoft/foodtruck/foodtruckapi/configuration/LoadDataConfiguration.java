package com.micorsoft.foodtruck.foodtruckapi.configuration;

import com.micorsoft.foodtruck.foodtruckapi.util.CSVToBeanLoader;
import com.micorsoft.foodtruck.foodtruckapi.util.FoodTruckDBDataLoaderHelper;
import com.micorsoft.foodtruck.foodtruckapi.vo.MobileFoodFacility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Configuration
@Slf4j
public class LoadDataConfiguration {


    @Bean
    CommandLineRunner loadCsvToInMemoryDB(CSVToBeanLoader csvToBeanLoader, FoodTruckDBDataLoaderHelper foodTruckDBDataLoaderHelper) {
        return args -> {
            Path path = Paths.get(ClassLoader.getSystemResource("data/Mobile_Food_Facility_Permit.csv").toURI());

            List<MobileFoodFacility> mobileFoodFacilities = (List<MobileFoodFacility>) csvToBeanLoader.loadCsvToBean(path, MobileFoodFacility.class);
            log.info("loaded {} record from CSV file ", mobileFoodFacilities.size());
            foodTruckDBDataLoaderHelper.loadDataToRepo(mobileFoodFacilities);

        };
    }
}

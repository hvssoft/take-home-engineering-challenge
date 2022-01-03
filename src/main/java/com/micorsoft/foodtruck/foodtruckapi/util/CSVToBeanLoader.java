package com.micorsoft.foodtruck.foodtruckapi.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
@Slf4j
public class CSVToBeanLoader {
    public List<? extends CsvBean> loadCsvToBean(Path path, Class clazz) {
        HeaderColumnNameMappingStrategy ms = new HeaderColumnNameMappingStrategy();
        ms.setType(clazz);
        List<CsvBean> returnList = null;
        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(clazz)
                    .withMappingStrategy(ms)
                    .build();
            returnList = csvToBean.parse();
        } catch (IOException e) {
            log.error("error while reading csv file", e);
            throw new RuntimeException(e);
        }
        return returnList;
    }
}

# Food truck API
This application  will be used to find out existing food trucks at a given location id or block. It can be also used to add new food truck data as well.

## To run the application

Platform: Java 11 need to be installed
Framework used : Spring boot, Open Csv, Lombok

To run the application from project root 
### Build
   mvn clean install
### Run
java -jar .\target\foodtruck-api-0.0.1-SNAPSHOT.jar

## APIs

There are 3 APIs exposed 
### 1) Getting all food trucks for a given block 
- Get localhost:8080/api/block/{blockid} .This will return a list of food truck in the given block. If not food truck found in the passed in block, it will return a no data found exception
### 2) Getting the food trucks for a given location
- Get localhost:8080/api/location/{locationId} .This will return the food truck in the given location. If no food truck found in the location it will return a no data found exception
### 3) Add a new food trucks for a given location
- Post localhost:8080/api.This will add a new food truck entry for the given locationId. If there is an existing food truck in the location, it will return an error

## Assumptions
- The location id is unique, there can be only one food truck in the passed in location.
- For simplicity the data added using post operation will be lost if the application is restarted as data is added only in the in memory data structure.
- Using th post request, only new location can be added. If the location is already existing, it cannot be updated. Another endpoint can be provided for data modification, which is not implemented.
- LocationId, blockId and address are mandatory field. It is enforced using JSR validator. Additional validations are not implemented as of not. This can be extended as needed using proper validation annotation.
- All data fields are loaded as Strings, no data conversion and or format checkings are implemented. This can be extended as needed


package org.jobrunr.utils.carbonaware;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CarbonApiMockResponses {

    private static String getJsonResponse(String fileName) {
        try(InputStream is = DayAheadEnergyPrices.class.getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                throw new FileNotFoundException("Resource not found: " + fileName);
            }
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static final String BELGIUM_2024_03_12 = getJsonResponse("org/jobrunr/utils/carbonaware/apiresponses/belgium_2024-03-12.json");
    public static final String GERMANY_2024_03_14 = getJsonResponse("org/jobrunr/utils/carbonaware/apiresponses/germany_2024-03-14.json");
    public static final String GERMANY_NO_DATA = getJsonResponse("org/jobrunr/utils/carbonaware/apiresponses/germany_no_data.json");

}
import handbook.model.City;
import handbook.tools.Parser;
import handbook.tools.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFourthModule {
    static List<City> citiesList = new ArrayList<>();

    @Test
    public void testMostPopulatedCity() throws Exception {
        Parser.readFromFile("src/test/resources/testData/population.txt", citiesList);
        Assert.assertEquals(1342523, Utils.getMostPopulatedCity(citiesList));
        citiesList.clear();
    }

    @Test
    public void testCitiesByRegion() throws Exception {
        Parser.readFromFile("src/test/resources/testData/sortByDistrict2.txt", citiesList);
        Map<String, Integer> regionMap = new HashMap<>();
        regionMap.put("Хабаровский край", 1);
        regionMap.put("Адыгея", 2);
        regionMap.put("Алтай", 3);
        Assert.assertEquals(Utils.getCitiesByRegion(citiesList), regionMap);
        citiesList.clear();
    }
}

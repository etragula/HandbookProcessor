package handbook.tools;

import handbook.model.City;

import java.util.*;

public class Utils {

    private Utils() {
    }

    public static void sortByName(List<City> citiesList) {
        citiesList.sort(Comparator.comparing(City::getName));
        citiesList.forEach(System.out::println);
    }

    public static void sortByDistrict(List<City> citiesList) {
        citiesList.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        citiesList.forEach(System.out::println);
    }

    public static int getMostPopulatedCity(List<City> citiesList) {
        City[] citiesArr = new City[citiesList.size()];
        citiesList.toArray(citiesArr);
        City city = Arrays.stream(citiesArr).max(Comparator.comparing(City::getPopulation)).get();
        for (int i = 0; i < citiesArr.length; i++) {
            if (citiesArr[i].getPopulation() == city.getPopulation())
                System.out.println("[" + i + "] = " + city.getPopulation());
        }
        return city.getPopulation();
    }

    public static Map<String, Integer> getCitiesByRegion(List<City> citiesList) {
        Map<String, Integer> regionMap = new HashMap<>();
        citiesList.forEach(city -> regionMap.merge(city.getRegion(), 1, (val, one) -> 1 + val));
        regionMap.forEach((a, b) -> System.out.println(a + " - " + b));
        return regionMap;
    }
}

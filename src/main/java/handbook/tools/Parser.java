package handbook.tools;

import handbook.model.City;
import handbook.model.CityCrud;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Parser {

    private Parser() {
    }

    public static void readFromFile(String filePath, List<City> citiesList) throws Exception {
        File file = new File(filePath);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String i = scan.nextLine();
                if (!i.replaceAll("\\s+", "").isEmpty()) parseCities(i, citiesList);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Данный файл не найден.");
        }

        for (City s : citiesList)
            System.out.println(s.toString());
    }

    public static void parseCities(String str, List<City> citiesList) throws Exception {
        CityCrud cityCrud = new CityCrud();
        String[] strArray = str.split(";");

        if (strArray.length != 6) throw new Exception("Невалидные данные");
        if (strArray[1].trim().isEmpty()) throw new Exception("Имя города - обязательный атрибут");

        String name = strArray[1].trim().isEmpty() ? "-" : strArray[1].trim();
        String region = strArray[2].trim().isEmpty() ? "-" : strArray[2].trim();
        String district = strArray[3].trim().isEmpty() ? "-" : strArray[3].trim();
        String population = strArray[4].replaceAll("\\s+", "");
        String foundation = strArray[5].replaceAll("\\s+", "");

        City city = new City(name, region, district);
        city.setPopulation(population.matches("\\d+") ? Integer.parseInt(population) : 0);
        city.setFoundation(foundation.matches("\\d+") ? Integer.parseInt(foundation) : 0);
        citiesList.add(city);
    }
}

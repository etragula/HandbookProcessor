import handbook.model.City;
import handbook.tools.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TestFirstModule {

    static List<City> citiesList = new ArrayList<>();

    /**
     * Некорректное имя файла.
     */
    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundException() throws Exception {
        Parser.readFromFile("", citiesList);
    }

    /**
     * Пустой файл.
     */
    @Test
    public void testEmptyFile() throws Exception {
        Exception ex = Assert.assertThrows(
                Exception.class,
                () -> Parser.readFromFile("src/test/resources/testData/empty.txt", citiesList)
        );
        Assert.assertEquals(ex.getMessage(), "Пустой файл.");
    }

    /**
     * Отсутствие имени города.
     */
    @Test
    public void testCityNameException() {
        try {
            Parser.readFromFile("src/test/resources/testData/withoutName.txt", citiesList);
            Assert.fail("expected exception was not occured.");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Имя города - обязательный атрибут");
        }
        Assert.assertEquals(citiesList.size(), 0);
    }

    /**
     * Отсутствие одного из элементов.
     */
    @Test
    public void testException() {
        try {
            Parser.readFromFile("src/test/resources/testData/elemAbsent.txt", citiesList);
            Assert.fail("expected exception was not occured.");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Невалидные данные");
        }
        Assert.assertEquals(citiesList.size(), 0);
    }

    /**
     * Файл с whiteSpace-ми в начале.
     */
    @Test
    public void testWhiteSpaces() throws Exception {
        String s1 = "model.City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation=1830}";
        String s2 = "model.City{name='Абаза', region='Хакасия', district='Сибирский', population=17111, foundation=1867}";
        String s3 = "model.City{name='Абакан', region='Хакасия', district='Сибирский', population=165183, foundation=1931}";
        Parser.readFromFile("src/test/resources/testData/whiteSpaces.txt", citiesList);
        Assert.assertEquals(citiesList.size(), 3);
        Assert.assertEquals(citiesList.get(0).toString(), s1);
        Assert.assertEquals(citiesList.get(1).toString(), s2);
        Assert.assertEquals(citiesList.get(2).toString(), s3);
        citiesList.clear();
    }

    /**
     * Файл с некорректными данными.
     */
    @Test
    public void testIncorrectInput() throws Exception {
        String s1 = "model.City{name='Горно-Алтайск', region='-', district='Сибирский', population=56928, foundation=1830}";
        String s2 = "model.City{name='Абаза', region='Хакасия', district='Сибирский', population=1711, foundation=0}";
        String s3 = "model.City{name='Абакан', region='-', district='Сибирский', population=0, foundation=0}";
        String s4 = "model.City{name='Абакан', region='-', district='Сибирский', population=0, foundation=0}";
        Parser.readFromFile("src/test/resources/testData/incorrectInput.txt", citiesList);
        Assert.assertEquals(citiesList.size(), 4);
        Assert.assertEquals(citiesList.get(0).toString(), s1);
        Assert.assertEquals(citiesList.get(1).toString(), s2);
        Assert.assertEquals(citiesList.get(2).toString(), s3);
        Assert.assertEquals(citiesList.get(3).toString(), s4);
        citiesList.clear();
    }
}

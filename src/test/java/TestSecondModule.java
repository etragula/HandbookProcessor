import handbook.model.City;
import handbook.tools.Parser;
import handbook.tools.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSecondModule {
    static List<City> citiesList = new ArrayList<>();

    @Test
    public void testSortByName() throws Exception {
        String s1 = "model.City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation=1973}";
        String s2 = "model.City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation=1830}";
        String s3 = "model.City{name='Дамурск', region='Хабаровский край', district='Дальневосточный', population=42977, foundation=1958}";
        String s4 = "model.City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation=1857}";
        String s5 = "model.City{name='Пагидель', region='Башкортостан', district='Приволжский', population=16365, foundation=1980}";
        String s6 = "model.City{name='Ягрыз', region='Татарстан', district='Приволжский', population=19299, foundation=1646}";
        Parser.readFromFile("src/test/resources/testData/sortByName.txt", citiesList);
        Utils.sortByName(citiesList);
        Assert.assertEquals(citiesList.size(), 6);
        Assert.assertEquals(citiesList.get(0).toString(), s1);
        Assert.assertEquals(citiesList.get(1).toString(), s2);
        Assert.assertEquals(citiesList.get(2).toString(), s3);
        Assert.assertEquals(citiesList.get(3).toString(), s4);
        Assert.assertEquals(citiesList.get(4).toString(), s5);
        Assert.assertEquals(citiesList.get(5).toString(), s6);
        citiesList.clear();
    }

    @Test
    public void testByDistrict() throws Exception {
        String s1 = "model.City{name='Дамурск', region='Хабаровский край', district='Дальневосточный', population=42977, foundation=1958}";
        String s2 = "model.City{name='Пагидель', region='Башкортостан', district='Приволжский', population=16365, foundation=1980}";
        String s3 = "model.City{name='Ягрыз', region='Татарстан', district='Приволжский', population=19299, foundation=1646}";
        String s4 = "model.City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation=1830}";
        String s5 = "model.City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation=1973}";
        String s6 = "model.City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation=1857}";
        Parser.readFromFile("src/test/resources/testData/sortByDistrict.txt", citiesList);
        Utils.sortByDistrict(citiesList);
        Assert.assertEquals(citiesList.size(), 6);
        Assert.assertEquals(citiesList.get(0).toString(), s1);
        Assert.assertEquals(citiesList.get(1).toString(), s2);
        Assert.assertEquals(citiesList.get(2).toString(), s3);
        Assert.assertEquals(citiesList.get(3).toString(), s4);
        Assert.assertEquals(citiesList.get(4).toString(), s5);
        Assert.assertEquals(citiesList.get(5).toString(), s6);
        citiesList.clear();
    }
}

package handbook.tools;

import handbook.model.City;
import handbook.model.CityCrud;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Menu() {
    }

    private static void displayMenu() {
        System.out.println(
                "                       > Меню <\n" +
                        "±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±\n" +
                        "1 --> Спарсить справочник.                          |\n" +
                        "2 --> Добавить справочник в таблицу.                |\n" +
                        "3 --> Показать отсортированный по имени справочник. |\n" +
                        "4 --> Показать отсортированный по району справочник.|\n" +
                        "5 --> Показать город(а) с наибольшим населением.    |\n" +
                        "6 --> Показать количество городов по регионам.      |\n" +
                        "7 --> Создать новую таблицу.                        |\n" +
                        "8 --> Вывести всю таблицу.                          |\n" +
                        "9 --> Удалить таблицу.                              |\n" +
                        "0 --> Выход.                                        |\n" +
                        "±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±±");
        System.out.print("Выбор: ");
    }

    public static void chooseOption(List<City> citiesList) throws Exception {
        Scanner scan = new Scanner(System.in);
        CityCrud cityCrud = new CityCrud();
        do {
            displayMenu();
            if (!scan.hasNextInt()) {
                scan.nextLine();
                continue;
            }
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("Вы выбрали опцию 1.\n" +
                            "Введите имя файла для чтения:");
                    Scanner scan2 = new Scanner(System.in);
                    String filePath = scan2.nextLine();
                    Parser.readFromFile("src/main/resources/" + filePath + ".txt", citiesList);
                    if (citiesList.size() == 0) System.out.println("Нечего добавлять.");
                    break;
                case 2:
                    System.out.println("Вы выбрали опцию 2.\n");
                    citiesList.forEach(cityCrud::insertRecord);
                    break;
                case 3:
                    System.out.println("Вы выбрали опцию 3.\n");
                    Utils.sortByName(citiesList);
                    break;
                case 4:
                    System.out.println("Вы выбрали опцию 4.\n");
                    Utils.sortByDistrict(citiesList);
                    break;
                case 5:
                    System.out.println("Вы выбрали опцию 5.\n");
                    if (citiesList.size() == 0) {
                        System.out.println("Нечего добавлять.");
                        break;
                    }
                    Utils.getMostPopulatedCity(citiesList);
                    break;
                case 6:
                    System.out.println("Вы выбрали опцию 6\n.");
                    Utils.getCitiesByRegion(citiesList);
                    break;
                case 7:
                    System.out.println("Вы выбрали опцию 7.\n");
                    cityCrud.creatTable();
                    break;
                case 8:
                    System.out.println("Вы выбрали опцию 8.\n");
                    cityCrud.selectRecord();
                    break;
                case 9:
                    System.out.println("Вы выбрали опцию 9.\n");
                    cityCrud.dropTable();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Выберете опцию.");
                    break;
            }
        } while (true);
    }
}

package ru.job4j.ood.lsp.quality;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControlQualityDemo {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(warehouse, shop, trash);
        Food fish1 = new Fish("Herring", new GregorianCalendar(2021, Calendar.AUGUST, 15).getTime(),
                new GregorianCalendar(2021, Calendar.JUNE, 6).getTime(),
                100, 10, "sea", 1.2);
        Food fish2 = new Fish("Cod", new GregorianCalendar(2021, Calendar.JULY, 15).getTime(),
                new GregorianCalendar(2021, Calendar.MAY, 15).getTime(),
                100, 10, "sea", 1);
        Food meat1 = new Meat("Pig", new GregorianCalendar(2021, Calendar.JUNE, 15).getTime(),
                new GregorianCalendar(2021, Calendar.MAY, 7).getTime(),
                70, 15, "ham", 3);
        Food meat2 = new Meat("Beef", new GregorianCalendar(2021, Calendar.MAY, 15).getTime(),
                new GregorianCalendar(2021, Calendar.APRIL, 10).getTime(),
                35, 15, "ham", 2);

        controlQuality.control(fish1);
        controlQuality.control(fish2);
        controlQuality.control(meat1);
        controlQuality.control(meat2);

        System.out.println(warehouse.toString());
        System.out.println(shop.toString());
        System.out.println(trash.toString());
    }
}

package ru.job4j.ood.lsp.quality;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {
    @Test
    public void whenFoodSendsToWarehouse() {
        List<Storage> storageList = new ArrayList<>();
        List<Food> expected = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        Food fish = new Fish("Herring", new GregorianCalendar(2021, Calendar.OCTOBER, 15).getTime(),
                new GregorianCalendar(2021, Calendar.JUNE, 6).getTime(),
                100, 10, "sea", 1.2);
        controlQuality.control(fish);
        expected.add(fish);
        controlQuality.resort();
        assertThat(warehouse.getStorageList(), is(expected));
    }

    @Test
    public void whenFoodSendsToShop() {
        List<Storage> storageList = new ArrayList<>();
        List<Food> expected = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        Food fish = new Fish("Cod", new GregorianCalendar(2021, Calendar.JULY, 15).getTime(),
                new GregorianCalendar(2021, Calendar.MAY, 15).getTime(),
                100, 10, "sea", 1);
        controlQuality.control(fish);
        expected.add(fish);
        assertThat(shop.getStorageList(), is(expected));
    }

    @Test
    public void whenFoodSendsToShopWithDiscount() {
        List<Storage> storageList = new ArrayList<>();
        List<Food> expected = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        Food meat = new Meat("Pig", new GregorianCalendar(2021, Calendar.JUNE, 30).getTime(),
                new GregorianCalendar(2021, Calendar.MAY, 7).getTime(),
                70, 15, "ham", 3);
        controlQuality.control(meat);
        meat.price = meat.price * (100 - meat.discount) / 100;
        expected.add(meat);
        assertThat(shop.getStorageList(), is(expected));
    }

    @Test
    public void whenFoodSendsToTrash() {
        List<Storage> storageList = new ArrayList<>();
        List<Food> expected = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        Food meat = new Meat("Beef", new GregorianCalendar(2021, Calendar.MAY, 15).getTime(),
                new GregorianCalendar(2021, Calendar.APRIL, 10).getTime(),
                35, 15, "ham", 2);
        controlQuality.control(meat);
        expected.add(meat);
        assertThat(trash.getStorageList(), is(expected));
     }

    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalDate() {
        List<Storage> storageList = new ArrayList<>();
        List<Food> expected = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        Food meat = new Meat("Beef", new GregorianCalendar(2021, Calendar.APRIL, 10).getTime(),
                new GregorianCalendar(2021, Calendar.MAY, 15).getTime(),
                35, 15, "ham", 2);
        controlQuality.control(meat);
    }

    @Test
    public void resortWhenWarehouseToTrash() {
        List<Storage> storageList = new ArrayList<>();
        List<Food> expected = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        Food meat = new Meat("Beef", new GregorianCalendar(2021, Calendar.MAY, 15).getTime(),
                new GregorianCalendar(2021, Calendar.APRIL, 10).getTime(),
                35, 15, "ham", 2);
        warehouse.getStorageList().add(meat);
        controlQuality.resort();
        expected.add(meat);
        assertThat(trash.getStorageList(), is(expected));
    }

    @Test
    public void resortWhenTrashToShop() {
        List<Storage> storageList = new ArrayList<>();
        List<Food> expected = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        Food fish = new Fish("Cod", new GregorianCalendar(2021, Calendar.JULY, 15).getTime(),
                new GregorianCalendar(2021, Calendar.MAY, 15).getTime(),
                100, 10, "sea", 1);
        trash.getStorageList().add(fish);
        controlQuality.resort();
        expected.add(fish);
        assertThat(shop.getStorageList(), is(expected));
    }

    @Test
    public void resortWhenShopToWarehouse() {
        List<Storage> storageList = new ArrayList<>();
        List<Food> expected = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        Food fish = new Fish("Herring", new GregorianCalendar(2021, Calendar.OCTOBER, 15).getTime(),
                new GregorianCalendar(2021, Calendar.JUNE, 6).getTime(),
                100, 10, "sea", 1.2);
        shop.getStorageList().add(fish);
        controlQuality.resort();
        expected.add(fish);
        assertThat(warehouse.getStorageList(), is(expected));
    }
}

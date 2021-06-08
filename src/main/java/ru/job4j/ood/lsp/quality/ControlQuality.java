package ru.job4j.ood.lsp.quality;

import java.util.Date;

public class ControlQuality {
    private final Warehouse warehouse;
    private final Shop shop;
    private final Trash trash;

    public ControlQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void control(Food food) {
        long totalLifeInDays = (food.expiryDate.getTime() - food.createDate.getTime()) / 1000 / 60 / 60 / 24;
        if (totalLifeInDays < 0) {
            throw new IllegalArgumentException("Check date of food in " + food);
        }
        long daysFromCreate = (new Date().getTime() - food.createDate.getTime()) / 1000 / 60 / 60 / 24;
        double levelOfQuality = (double) daysFromCreate / totalLifeInDays * 100;
        if (levelOfQuality > 0 && levelOfQuality < 25) {
            ControlQualityContext context = new ControlQualityContext(new SendToStorageStrategy());
            context.executeStrategy(food, warehouse);
        } else if (levelOfQuality >= 25 && levelOfQuality <= 75) {
            ControlQualityContext context = new ControlQualityContext(new SendToStorageStrategy());
            context.executeStrategy(food, shop);

        } else if (levelOfQuality > 75 && levelOfQuality <= 100) {
            ControlQualityContext context = new ControlQualityContext(new SendToShopAndDiscountStrategy());
            context.executeStrategy(food, shop);
        } else {
            ControlQualityContext context = new ControlQualityContext(new SendToStorageStrategy());
            context.executeStrategy(food, trash);
        }
    }


}

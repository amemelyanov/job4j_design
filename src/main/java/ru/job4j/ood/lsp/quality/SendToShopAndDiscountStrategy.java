package ru.job4j.ood.lsp.quality;

public class SendToShopAndDiscountStrategy implements ControlQualityStrategy {
    @Override
    public void execute(Food food, Storage storage) {
        food.price = food.price * (100 - food.discount) / 100;
        storage.add(food);
    }
}

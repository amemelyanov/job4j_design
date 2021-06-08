package ru.job4j.ood.lsp.quality;

public class SendToStorageStrategy implements ControlQualityStrategy {

    @Override
    public void execute(Food food, Storage storage) {
        storage.add(food);
    }
}

package ru.job4j.ood.lsp.quality;

public class ControlQualityContext {
    private ControlQualityStrategy strategy;

    public ControlQualityContext(ControlQualityStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Food food, Storage storage) {
        strategy.execute(food, storage);
    }

}

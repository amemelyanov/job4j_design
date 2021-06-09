package ru.job4j.ood.lsp.quality;

import java.util.List;

public class ControlQuality {

    private List<Storage> storageList;

    public ControlQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    public void control(Food food) {
        for (Storage storage : storageList) {
            if (storage.accept(food)) {
                storage.add(food);
            }
        }
    }
}

package ru.job4j.ood.lsp.quality;

import java.util.ArrayList;
import java.util.Iterator;
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
                break;
            }
        }
    }

    public void resort() {
        List<Food> listForResorting = new ArrayList<>();
        for (Storage storage : storageList) {
            listForResorting.addAll(storage.getStorageList());
            storage.clear();
        }
        for (Food food : listForResorting) {
            control(food);
        }
    }
}

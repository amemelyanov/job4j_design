package ru.job4j.ood.lsp.quality;

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
        for (Storage storage : storageList) {
            Iterator<Food> it = storage.getStorageList().iterator();
            while (it.hasNext()) {
                Food current = it.next();
                if (!storage.accept(current)) {
                    control(current);
                    it.remove();
                }
            }
        }
    }
}

package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String result = "";
        if (count == 0) {
            return result;
        } else if (count < queue.size()) {
            for (int i = 0; i < count; i++) {
                result = queue.poll().name();
            }
        } else {
            int localCount = queue.size();
            for (int i = 0; i < localCount; i++) {
                result = queue.poll().name();
            }
        }
        return result;
    }

    public String getLastUpsetCustomer() {
        String result = "";
        if (count == 0) {
           return queue.poll().name();
        } else if (count < queue.size()) {
            for (int i = 0; i <= count; i++) {
                result = queue.poll().name();
            }
        }
        return result;
    }
}

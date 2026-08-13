package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // fill queue
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {

            // move k-1 elements
            for (int i = 1; i < everyDishNumberToEat; i++) {
                queue.add(queue.poll());
            }

            // remove k-th
            result.add(queue.poll());
        }

        return result;
    }
}

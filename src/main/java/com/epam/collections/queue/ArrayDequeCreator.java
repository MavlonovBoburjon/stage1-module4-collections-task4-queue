package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 1. initial (2 tadan)
        deque.addLast(firstQueue.poll());
        deque.addLast(firstQueue.poll());

        deque.addLast(secondQueue.poll());
        deque.addLast(secondQueue.poll());

        // 2. main loop
        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {

            // FIRST PLAYER
            Integer cardFromDeque1 = deque.pollFirst();
            if (cardFromDeque1 != null) {
                firstQueue.add(cardFromDeque1);
            }

            deque.addLast(firstQueue.poll());
            deque.addLast(firstQueue.poll());

            // SECOND PLAYER
            Integer cardFromDeque2 = deque.pollFirst();
            if (cardFromDeque2 != null) {
                secondQueue.add(cardFromDeque2);
            }

            deque.addLast(secondQueue.poll());
            deque.addLast(secondQueue.poll());
        }

        // 🔥 MUHIM: qolgan elementlarni ham qo‘shish
        while (!firstQueue.isEmpty()) {
            deque.addLast(firstQueue.poll());
        }

        while (!secondQueue.isEmpty()) {
            deque.addLast(secondQueue.poll());
        }

        return deque;
    }
}

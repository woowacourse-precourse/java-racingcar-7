package racingcar.domain;

import racingcar.NumberGenerator;

import java.util.*;

public class Race {
    private final NumberGenerator numberGenerator;
    private final List<Car> cars = new ArrayList<>();

    public Race(final NumberGenerator numberGenerator, final List<String> names) {
        this.numberGenerator = numberGenerator;
        for (String name: names) {
            cars.add(new Car(name));
        }
    }

    public void run(final int rounds) {
        Round round = new Round(cars);
        for (int num = 0; num < rounds; num++) {
            round.play(createIntegers());
            System.out.println(round);
        }
    }

    private List<Integer> createIntegers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            numbers.add(numberGenerator.generate());
        }
        return numbers;
    }

    public List<Car> getWinners() {
        return extractFrom(priorityQueue());
    }

    private PriorityQueue<Car> priorityQueue() {
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(cars);
        return priorityQueue;
    }

    private List<Car> extractFrom(final PriorityQueue<Car> priorityQueue) {
        List<Car> winners = new ArrayList<>();
        Car first = priorityQueue.poll();
        assert first != null;
        winners.add(first);
        while (!priorityQueue.isEmpty() && first.hasSameDistanceWith(priorityQueue.peek())) {
            winners.add(priorityQueue.poll());
        }
        return winners;
    }
}

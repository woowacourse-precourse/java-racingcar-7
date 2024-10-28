package racingcar.domain;

import racingcar.NumberGenerator;

import java.util.*;

public class Race {
    private final NumberGenerator numberGenerator;
    private final List<Car> cars = new ArrayList<>();
    private final StringBuilder result = new StringBuilder("\n실행 결과\n");

    public Race(final NumberGenerator numberGenerator, final List<String> names) {
        this.numberGenerator = numberGenerator;
        for (String name: names) {
            cars.add(new Car(name));
        }
    }

    public void run(final int rounds) {
        for (int trial = 0; trial < rounds; trial++) {
            playOneRound();
        }
    }

    private void playOneRound() {
        for (Car car: cars) {
            car.execute(numberGenerator.generate());
        }
        appendRoundResult();
    }

    private void appendRoundResult() {
        for (Car car: cars) {
            result.append(car).append("\n");
        }
        result.append("\n");
    }

    public String result() {
        result.append("최종 우승자 : ");
        result.append(String.join(", ", winners().stream().map(Car::getName).toList()));
        return result.toString();
    }

    private List<Car> winners() {
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

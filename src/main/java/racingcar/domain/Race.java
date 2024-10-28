package racingcar.domain;

import racingcar.NumberGenerator;
import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

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
        for (int num = 0; num < rounds; num++) {
            play(createIntegers());
            System.out.println(roundResult());
        }
    }

    private void play( List<Integer> numbers) {
        if (cars.size() != numbers.size()) {
            throw new CustomException(ExceptionCode.SIZE_NOT_MATCHED);
        }
        for (int round=0; round<numbers.size(); round++) {
            Car car = cars.get(round);
            car.execute(numbers.get(round));
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

    private String roundResult() {
        StringBuilder builder = new StringBuilder();
        for (Car car: cars) {
            builder.append(car).append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }
}

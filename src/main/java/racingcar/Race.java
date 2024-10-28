package racingcar;

import java.util.*;

public class Race {
    private final NumberGenerator numberGenerator;
    private final List<Car> cars;

    public Race(final NumberGenerator numberGenerator, final List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    // TODO: 함수 분리하기
    public void run(final int rounds) {
        for (int round = 0; round < rounds; round++) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < cars.size(); i++) {
                numbers.add(numberGenerator.generateNumber(4));
            }
            Round.play(cars, numbers);
            Round.print(cars);
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(cars);
        Car first = priorityQueue.poll();
        assert first != null;
        winners.add(first);
        while (!priorityQueue.isEmpty() && first.hasSameDistanceWith(priorityQueue.peek())) {
            winners.add(priorityQueue.poll());
        }
        return winners;
    }
}

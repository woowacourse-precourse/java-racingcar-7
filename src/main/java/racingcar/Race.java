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
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(cars);
        Car prev = priorityQueue.poll();
        while (Objects.equals(Objects.requireNonNull(prev).getDistance(), Objects.requireNonNull(priorityQueue.peek()).getDistance())) {
            winners.add(priorityQueue.poll());
        }
        return winners;
    }
}

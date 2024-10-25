package racingcar.race;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final RaceMoveStrategy raceMoveStrategy;

    public Race(List<Car> cars, RaceMoveStrategy raceMoveStrategy) {
        this.cars = cars;
        this.raceMoveStrategy = raceMoveStrategy;
    }

    public void process() {
        for (Car car : cars) {
            boolean canMove = raceMoveStrategy.go();
            if (canMove) {
                car.move();
            }
        }
    }

    public void complete() {
        int winnerPosition = getWinnerPosition(cars);

        List<Car> winnerCars = new ArrayList<>();

        for (Car car : cars) {
            if (winnerPosition == car.getPosition()) {
                winnerCars.add(car);
            }
        }

        printCars(winnerCars, ", ");
    }

    private void printCars(List<Car> cars, String delimiter) {
        String result = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(delimiter));

        System.out.println("최종 우승자 : " + result);
    }

    private int getWinnerPosition(List<Car> cars) {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
        return winnerPosition;
    }

    public void printProgress() {
        for (Car car : cars) {
            String positionBar = getBar('-', car.getPosition());
            System.out.println(car.getName() + " : " + positionBar);
        }
        System.out.println();
    }

    private String getBar(char pattern, int count) {
        StringBuilder bar = new StringBuilder();
        bar.repeat(pattern, count);
        return bar.toString();
    }
}

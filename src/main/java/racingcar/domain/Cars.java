package racingcar.domain;

import racingcar.view.StatusView;

import java.util.List;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    private Cars(List<String> names) {
        cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public static Cars from(List<String> names) {
        return new Cars(names);
    }

    public void racing(int moveNum) {
        StatusView.printExecutionResult();
        IntStream.range(0, moveNum)
                .forEach(i -> {
                    cars.forEach(Car::moveOrStop);
                    StatusView.printStatus(cars);
                });
    }

    public List<Car> determineWinner() {
        int maxAdvanceNum = getMaxAdvanceNum();
        return getWinnerCars(maxAdvanceNum);
    }

    public int getMaxAdvanceNum() {
        return cars.stream()
                .mapToInt(Car::getAdvanceNum)
                .max()
                .orElse(0);
    }

    private List<Car> getWinnerCars(int maxAdvanceNum) {
        return cars.stream()
                .filter(car -> car.getAdvanceNum() == maxAdvanceNum)
                .toList();
    }
}
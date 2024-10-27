package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarsInRace {

    private static List<Car> carsList = new ArrayList<>();

    public CarsInRace(List<Car> carsList) {
        this.carsList = carsList;
    }

    public void startRaceOnce() {
        for (Car car : carsList) {
            car.move();
        }
    }

    public static List<Car> getCarsInRace() {
        return carsList;
    }

    public static List<String> getWinnersName() {
        List<String> winnersName = new ArrayList<>();

        for (Car car : getWinners()) {
            winnersName.add(car.getName());
        }

        return winnersName;
    }

    private static List<Car> getWinners() {
        int maxWinCount = carsList.stream()
                .max(Comparator.comparingInt(Car::getWinCount))
                .get()
                .getWinCount();

        return carsList.stream()
                .filter(car -> car.getWinCount() == maxWinCount)
                .collect(Collectors.toList());
    }
}

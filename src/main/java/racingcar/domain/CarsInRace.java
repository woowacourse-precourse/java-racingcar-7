package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarsInRace {

    private static List<Car> carsInRace = new ArrayList<>();
    private static int carsCount = 0;

    public CarsInRace(List<Car> carsInRace) {
        this.carsInRace = carsInRace;
        this.carsCount = carsInRace.size();
    }

    public void startRaceOnce() {
        for (Car car : carsInRace) {
            car.move();
        }
    }

    public int getCarsCount() {
        return carsCount;
    }

    public static List<Car> getCarsInRace() {
        return carsInRace;
    }

    public static List<String> getWinnersName() {
        List<String> winnersName = new ArrayList<>();

        for (Car car : getWinners()) {
            winnersName.add(car.getName());
        }

        return winnersName;
    }

    private static List<Car> getWinners() {
        int maxWinCount = carsInRace.stream()
                .max(Comparator.comparingInt(Car::getWinCount))
                .get()
                .getWinCount();

        return carsInRace.stream()
                .filter(car -> car.getWinCount() == maxWinCount)
                .collect(Collectors.toList());
    }
}

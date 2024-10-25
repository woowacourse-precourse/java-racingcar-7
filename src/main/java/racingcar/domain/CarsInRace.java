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
}

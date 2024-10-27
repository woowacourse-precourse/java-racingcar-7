package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<String> carList = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        List<Car> cars = createCars(carList);
        Race race = new Race(cars);
        race.startRace(tryCount);
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

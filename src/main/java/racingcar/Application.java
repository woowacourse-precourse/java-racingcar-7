package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RaceInput input = new RaceInput();

        String carNames = input.getCarNames();
        int totalAttempts = input.getTotalAttempts();

        List<String> carNamesList = splitCarNames(carNames);

        List<Car> cars = createCars(carNamesList);

        runRace(cars, totalAttempts);

        RaceOutput.displayRaceResults(cars, totalAttempts);
        RaceOutput.displayWinners(cars);
    }

    public static List<String> splitCarNames(String carNames) {
        List<String> carNamesList = new ArrayList<>(List.of(carNames.split(",")));

        for (int i = 0; i < carNamesList.size(); i++) {
            carNamesList.set(i, carNamesList.get(i).trim());
        }

        return carNamesList;
    }

    public static List<Car> createCars(List<String> carNamesList) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNamesList) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public static void runRace(List<Car> cars, int totalAttempts) {
        for (int i = 0; i < totalAttempts; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }
}

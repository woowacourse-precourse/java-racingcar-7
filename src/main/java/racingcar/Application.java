package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carName = Console.readLine();
        createCarNames(carName);
    }

    public static List<String> createCarNames(String carName) {
        List<String> carNames = Arrays.stream(carName.split(","))
                .toList();

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(name + "이름이 5자리가 넘습니다");
            }
        }

        return carNames;
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> moveCars(List<Car> cars) {
        List<Car> movingCars = new ArrayList<>();

        for (Car car : cars) {
            movingCars.add(car.move());
        }

        return movingCars;
    }

    public List<List<Car>> race(List<Car> cars, int raceTime) {
        List<List<Car>> racingRecords = new ArrayList<>();
        racingRecords.add(cars);

        for (int i = 0; i < raceTime; i++) {
            List<Car> racingCars = moveCars(racingRecords.get(i));
            racingRecords.add(racingCars);
        }
        racingRecords.remove(0);

        return racingRecords;
    }
}

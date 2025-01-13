package racingcar;

import static racingcar.Car.createDefaultCar;

import exception.CustomIllegalArgException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.RandomGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playRacing() {
        for (Car car : cars) {
            car.move();
        }
    }

    public static Cars from(String inputCarNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            cars.add(createDefaultCar(carName, new RandomGenerator()));
        }
        return new Cars(cars);
    }

    public List<String> getForwardInfos() {
        List<String> forwardInfos = new ArrayList<>();
        for (Car car : cars) {
            forwardInfos.add(car.carForwardInfo());
        }
        return forwardInfos;
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new CustomIllegalArgException("No cars found"));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

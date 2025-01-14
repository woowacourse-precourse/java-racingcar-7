package racingcar;

import static racingcar.Car.createDefaultCar;

import exception.CustomIllegalArgException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String inputCarNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            cars.add(createDefaultCar(carName));
        }
        return new Cars(cars);
    }

    public void playRacing(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new CustomIllegalArgException("No cars found"));

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}

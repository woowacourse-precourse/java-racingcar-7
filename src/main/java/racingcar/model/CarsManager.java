package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CarsManager {

    private final List<Car> cars;

    public CarsManager(List<Car> cars) {
        this.cars = cars;
    }

    public static CarsManager by(List<String> carNames){
        return new CarsManager(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move(){
        for (Car car : cars) {
            car.move();
        }
    }

    public String getWinners() {
        StringJoiner result = new StringJoiner(", ");
        int maxValue = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxValue)
                .collect(Collectors.toList());

        winners.stream()
                .map(Car::getName)
                .forEach(result::add);

        return result.toString();
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::getResult)
                .collect(Collectors.joining());
    }

}

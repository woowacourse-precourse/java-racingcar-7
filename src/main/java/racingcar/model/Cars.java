package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getWinners() {
        sortCarsByPosition();
        int maxPosition = cars.getFirst().getPosition();
        List<Car> winners = new ArrayList<>();
        for (Car winner : cars) {
            if (winner.getPosition() < maxPosition) {
                break;
            }
            winners.add(winner);
        }

        return winners;

    }

    private void sortCarsByPosition() {
        cars.sort((car1, car2) -> Integer.compare(car2.getPosition(), car1.getPosition()));
    }


}

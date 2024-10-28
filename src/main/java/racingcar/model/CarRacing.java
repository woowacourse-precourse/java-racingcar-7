package racingcar.model;

import java.util.List;

public class CarRacing {

    private final List<Car> cars;


    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    public void startRacing() {
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public String recordRaceStatus() {
        StringBuilder status = new StringBuilder();
        for (Car car : cars) {
            status.append(car.getCarName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }
        return status.toString();
    }


    public List<String> getWinner() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .toList();
    }
}

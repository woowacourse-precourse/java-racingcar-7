package racingcar.model.race;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Car;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(){
        for(Car car : cars){
           car.move();
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

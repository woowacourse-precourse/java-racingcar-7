package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void init(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void move(MoveCondition moveCondition) {
        for (Car car : cars) {
            car.move(moveCondition);
        }
    }

    public List<String> findWinners(List<Position> positions) {
        Winners winners = new Winners(cars);
        return winners.findWinners(positions);
    }

    public List<Position> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }

    public String getCarName(int i) {
        return cars.get(i).getName();
    }

    public int getSize() {
        return cars.size();
    }
}

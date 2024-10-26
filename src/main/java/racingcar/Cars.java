package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public static Cars withNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> move(MoveCondition moveCondition) {
        return cars.stream()
                .map(car -> car.move(moveCondition))
                .toList();
    }

    public List<String> findWinners(List<Integer> positions) {
        Winners winners = new Winners(cars);
        return winners.findWinners(positions);
    }

    public List<Integer> getPositions() {
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

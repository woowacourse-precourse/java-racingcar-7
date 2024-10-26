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

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> move(MoveCondition moveCondition) {
        return cars.stream()
                .map(car -> car.move(moveCondition))
                .toList();
    }

    public List<String> findWinners(List<Integer> positions) {
        int winnerPosition = determineWinnerPosition(positions);
        return cars.stream()
                .filter(car -> car.isWinnerPosition(winnerPosition))
                .map(Car::getName)
                .toList();
    }

    private int determineWinnerPosition(List<Integer> positions) {
        return positions.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
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

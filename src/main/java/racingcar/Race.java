package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private int moveCount;

    public void addCar(Car car) {
        cars.add(car);
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void playTurn() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCarsStatus() {
        return new ArrayList<>(cars); // 원본 보호
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

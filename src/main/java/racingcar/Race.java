package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int moveCount;

    public Race(List<String> cars, int moveCount) {
        if (moveCount == 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }

        this.cars = createCars(cars);
        this.moveCount = moveCount;
    }

    private List<Car> createCars(List<String> carsName) {
        Set<String> uniqueCarsName = new HashSet<>(carsName);

        if (carsName.size() != uniqueCarsName.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

        return carsName.stream()
                .map(Car::new)
                .toList();
    }

    public void playRacing() {
        for (int i = 0; i < moveCount; i++) {
            carsMove();
            OutputView.printRacingResult(cars);
        }

        OutputView.printWinner(getWinner());
    }

    private void carsMove() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    private List<String> getWinner() {
        int maxPosition = 0;
        List<String> winner = new ArrayList<>();

        for (Car car : cars) {
            maxPosition = getMaxPosition(car.getPosition(), maxPosition);
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

    private int getMaxPosition(int position, int maxPosition) {
        if (position >= maxPosition) {
            return position;
        }

        return maxPosition;
    }
}

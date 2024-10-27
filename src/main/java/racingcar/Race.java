package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int tryCount;

    public Race(List<String> cars, int tryCount) {
        ExceptionHandler.validateMoveCount(tryCount);

        this.cars = createCars(cars);
        this.tryCount = tryCount;
    }

    private List<Car> createCars(List<String> carsName) {
        Set<String> uniqueCarsName = new HashSet<>(carsName);

        ExceptionHandler.validateDuplicateCarName(carsName.size(), uniqueCarsName.size());

        return carsName.stream()
                .map(Car::new)
                .toList();
    }

    public void playRacing() {
        for (int i = 0; i < tryCount; i++) {
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

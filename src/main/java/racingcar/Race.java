package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int moveCount;

    public Race(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
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

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Racing {
    Output output = new Output();

    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

    public void racing(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) car.move();
        }
    }

    public int compareMoveCount(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

    public List<String> getWinner(List<Car> cars) {
        int max = compareMoveCount(cars);
        return cars.stream()
                .filter(car -> car.getMoveCount() == max)
                .map(Car::getName)
                .toList();
    }

    public void play(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            racing(cars);
            output.printRacingResult(cars);
        }
    }
}

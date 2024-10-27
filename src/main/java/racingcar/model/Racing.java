package racingcar.model;

import racingcar.message.ExceptionCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {

    List<Car> carList;

    public Racing(final List<Car> carList) {
        this.carList = new ArrayList<>(validate(carList));
    }

    private List<Car> validate(final List<Car> carList) {
        Set<String> uniqueCarNames = new HashSet<>();

        for (Car car : carList) {
            if (!uniqueCarNames.add(car.getName())) {
                throw new IllegalArgumentException(ExceptionCode.DUPLICATE_CAR_NAME.getDescription());
            }
        }

        return carList;
    }

    public void runRacingTurn() {
        for (final Car car : carList) {
            car.goOrStop();
        }
    }

    public List<String> computeWinner() {
        List<String> winners = new ArrayList<>();
        int fastest = 0;

        for (final Car car : this.carList) {
            if (fastest < car.getFinalDistance()) {
                fastest = car.getFinalDistance();
                winners.clear();
                winners.add(car.getName());
            } else if (fastest == car.getFinalDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
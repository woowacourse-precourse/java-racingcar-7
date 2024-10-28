package racingcar.stadium;

import java.util.List;
import racingcar.util.RandomNumber;
import racingcar.car.Car;
import racingcar.car.Cars;

public class Racing {

    private final Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public static Racing from(Cars cars) {
        return new Racing(cars);
    }

    public List<String> getWinnerCarNames() {
        return cars.getWinners();
    }

    public void moveCars() {
        for (Car car : cars.getCars()) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private boolean canMove() {
        int start = 0;
        int end = 9;
        int conditionNumber = 4;

        return RandomNumber.generateInRange(start, end) >= conditionNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Car car : cars.getCars()) {
            builder.append(getCarsData(car));
        }
        builder.append("\n");

        return builder.toString();
    }

    private String getCarsData(Car car) {
        String positionMark = "-";

        return String.format(
            "%s : %s\n",
            car.getName(),
            positionMark.repeat(car.getPosition())
        );
    }
}

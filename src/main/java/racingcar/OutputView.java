package racingcar;

import java.util.List;

public class OutputView {

    public void println(final String message) {
        System.out.println(message);
    }

    public void printCars(final List<Car> cars) {
        cars.forEach(this::printCar);
    }

    public void printCar(final Car car) {
        String message = carNameFormat(car.getName()) + carMoveCountFormat(car.getMoveCount());
        println(message);
    }

    private String carNameFormat(final String carName) {
        String format = "%s : ";
        return String.format(format, carName);
    }

    private String carMoveCountFormat(final int moveCount) {
        StringBuilder builder = new StringBuilder();
        for (int count = 0; count < moveCount; count++) {
            builder.append("-");
        }
        return builder.toString();
    }

}

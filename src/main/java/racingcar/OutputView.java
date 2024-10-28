package racingcar;

import java.util.List;

public class OutputView {

    public void print(final String message) {
        System.out.print(message);
    }

    public void endLine() {
        System.out.println();
    }

    public void println(final String message) {
        print(message);
        endLine();
    }

    public void printCarsStatus(final List<Car> cars) {
        cars.forEach(this::printCarStatus);
    }

    public void printCarStatus(final Car car) {
        String message = carNameFormatWhenShowStatus(car.getName())
                + carMoveCountFormatWhenShowStatus(car.getMoveCount());
        println(message);
    }

    public void printNames(final List<String> names) {
        String message = String.join(", ", names);
        println(message);
    }

    private String carNameFormatWhenShowStatus(final String carName) {
        String format = "%s : ";
        return String.format(format, carName);
    }

    private String carMoveCountFormatWhenShowStatus(final int moveCount) {
        StringBuilder builder = new StringBuilder();
        for (int count = 0; count < moveCount; count++) {
            builder.append("-");
        }
        return builder.toString();
    }

}

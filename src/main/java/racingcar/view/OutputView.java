package racingcar.view;

import racingcar.model.domain.Vehicle;
import racingcar.model.infrastructure.Car;
import racingcar.view.enumerate.OutputConstant;

import java.util.List;

import static racingcar.view.enumerate.OutputConstant.RESULT_PRINT_SENTENCE;

public class OutputView {
    private final static String FORWARD_DISTANCE_SIGN = "-";
    private final static String NAME_DELIMITER = ", ";
    private final static String Colons = " : ";

    public void print(OutputConstant phrase) {
        System.out.println(phrase.getSentence());
    }

    public void printRaceResultPerGame(List<Vehicle> cars) {
        cars.forEach(car -> {
            printCarName(car.getName());
            printCarDistance(car.getDistance());
        });
        System.out.println();
    }

    private void printCarName(String carName) {
        System.out.print(carName + Colons);
    }

    private void printCarDistance(int distance) {
        System.out.println(FORWARD_DISTANCE_SIGN.repeat(distance));
    }


    public void printWinners(List<String> winners) {
        System.out.print(RESULT_PRINT_SENTENCE.getSentence());
        System.out.print(String.join(NAME_DELIMITER, winners));
    }
}
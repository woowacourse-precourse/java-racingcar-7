package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static final String RESULT_MESSAGE = "\n실행 결과";
    public static final String POSITION_MESSAGE_DELIMITER = "-";

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCurrentPosition(List<Car> cars) {
        cars.forEach(car -> {
            String output = car.getName() + POSITION_MESSAGE_DELIMITER.repeat(car.getPosition());
            System.out.println(output);
        });
        System.out.println();
    }
}

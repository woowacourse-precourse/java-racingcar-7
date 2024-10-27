package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static final String RESULT_MESSAGE = "\n실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static final String POSITION_MESSAGE_DELIMITER = "-";
    public static final String WINNER_MESSAGE_DELIMITER = ", ";

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCurrentPosition(List<Car> cars) {
        cars.forEach(car -> {
            String output = getCurrentPosition(car);
            System.out.println(output);
        });
        System.out.println();
    }

    private String getCurrentPosition(Car car) {
        return car.getName() + " : " + POSITION_MESSAGE_DELIMITER.repeat(car.getPosition());
    }

    public void printWinners(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(String.join(WINNER_MESSAGE_DELIMITER, winners));
    }
}

package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class Output {
    private static final String OUTPUT_MESSAGE = "실행 결과";
    private static final String DELIMITER = " : ";
    private static final String MOVE_DELIMITER = "-";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_DELIMETER = ", ";


    public void printExecutionResult() {
        System.out.println(OUTPUT_MESSAGE);
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + DELIMITER);
            System.out.println(MOVE_DELIMITER.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(FINAL_WINNER_MESSAGE + String.join(WINNER_DELIMETER, winners));
    }
}

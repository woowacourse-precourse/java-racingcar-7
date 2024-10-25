package racingcar.view;

import static racingcar.enums.Message.EXECUTION_RESULT_HEADER;
import static racingcar.enums.Message.FINAL_WINNER;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printExecutionResultHeader() {
        System.out.println(EXECUTION_RESULT_HEADER);
    }

    public void printCarsStatus(Map<String, String> cars) {
        cars.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.print(FINAL_WINNER.getMessage() + winnerNames);
    }
}

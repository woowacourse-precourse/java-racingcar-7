package racingcar.view;

import racingcar.dto.CarStatusDto;
import racingcar.enums.Message;

import java.util.List;

public class OutputView {

    private static final String NAME_DELIMITER = ", ";

    public static void printInputCarNameMessage() {
        System.out.println(Message.INPUT_CAR_NAME);
    }

    public static void printInputRoundMessage() {
        System.out.println(Message.INPUT_ROUND);
    }

    public static void printRoundResult(List<CarStatusDto> roundResult) {
        for (CarStatusDto carStatusDto : roundResult) {
            System.out.println(carStatusDto.toString());
        }
        System.out.println();
    }

    public static void printWinnerNames(List<String> names) {
        System.out.println(Message.FINAL_WINNER + String.join(NAME_DELIMITER, names));
    }

    public static void printExecutionResultMessage() {
        System.out.println(Message.EXECUTION_RESULT);
    }
}

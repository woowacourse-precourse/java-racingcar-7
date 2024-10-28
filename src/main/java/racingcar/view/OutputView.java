package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    public static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_MARKER = "-";
    public static final String WINNER_DELIMITER = ", ";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";



    public void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public void printResult() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarPosition(String name, int position) {
        System.out.print(name + NAME_POSITION_SEPARATOR);
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_MARKER);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(WINNER_DELIMITER, winners);
        System.out.println(FINAL_WINNER_MESSAGE + winnerNames);
    }

    public void printEnter() {
        System.out.println();
    }
}

package racingcar.view.output;

import java.util.List;

import static java.lang.String.format;

public class OutputView {
    // Output Messages
    public static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_TITLE = "실행 결과";
    public static final String RESULT_DETAIL = "%s : %s";
    public static final String FINAL_RESULT = "최종 우승자 : %s";

    // Delimiter
    public static final String WINNER_DELIMITER = ", ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printRound(List<String> roundResults) {
        for (String roundResult : roundResults) {
            System.out.println(roundResult);
        }
    }

    public void printWinners(List<String> winnerList) {
        String winners = String.join(WINNER_DELIMITER, winnerList);
        String finalResultFormat = format(FINAL_RESULT, winners);

        System.out.println(finalResultFormat);
    }
}

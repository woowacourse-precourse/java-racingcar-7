package racingcar;

import java.util.List;
import java.util.Map;

public class OutputView {
    private final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ROUND_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printRoundCountInputMessage() {
        System.out.println(ROUND_COUNT_INPUT_MESSAGE);
    }

    public void printRoundResults(List<RoundHistory> roundHistories) {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);

        roundHistories.forEach(this::printRoundHistory);
    }

    private void printRoundHistory(RoundHistory roundHistory) {
        roundHistory.nameAndPosition().forEach((name, position) ->
                System.out.println(name + " : " + "-".repeat(position))
        );
        System.out.println();
    }

    public void printWinner(List<String> winnerList) {
        String winner = String.join(", ", winnerList);
        System.out.println(FINAL_WINNER_MESSAGE + winner);
    }
}
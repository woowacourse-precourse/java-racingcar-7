package racingcar.view;

import racingcar.dto.RacingResult;
import racingcar.util.RacingResultFormatter;
import java.util.List;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_FORMAT = "최종 우승자 : %s";

    public void printResult() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printWinners(String winners) {
        System.out.printf(FINAL_WINNER_FORMAT, winners);
    }

    public void printRacing(List<RacingResult> racingResults) {
        System.out.println(RacingResultFormatter.format(racingResults));
    }
}
package racingcar.view;

import java.util.List;

import racingcar.dto.RacingCarProgress;
import racingcar.dto.RacingCarResult;
import racingcar.dto.RacingCarWinner;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ASK_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_TITLE = LINE_SEPARATOR + "실행 결과";
    private static final String WINNER = "최종 우승자 : %s";
    private static final String WINNER_DELIMITER = ", ";
    private static final String HYPHEN = "-";
    private static final String PROGRESS = "%s : %s";

    public void printAskCars() {
        printMessage(ASK_CARS);
    }

    public void printAskCount() {
        printMessage(ASK_COUNT);
    }

    public void printResultTitle() {
        printMessage(RESULT_TITLE);
    }

    public void printResults(final List<RacingCarResult> results) {
        StringBuilder sb = new StringBuilder();
        for (RacingCarResult result : results) {
            final String resultMessage = createResultMessage(result);
            sb.append(resultMessage);
            sb.append(LINE_SEPARATOR);
        }
        System.out.print(sb);
    }

    public void printWinner(final RacingCarWinner racingCarWinner) {
        final List<String> winnerNames = racingCarWinner.winnerNames();
        final String join = String.join(WINNER_DELIMITER, winnerNames);
        final String message = String.format(WINNER, join);
        printMessage(message);
    }

    private String createResultMessage(final RacingCarResult result) {
        StringBuilder sb = new StringBuilder();
        final List<RacingCarProgress> progresses = result.progresses();
        for (RacingCarProgress progress : progresses) {
            final String carName = progress.carName();
            final int score = progress.score();
            final String message = String.format(PROGRESS, carName, HYPHEN.repeat(score));
            sb.append(message);
            sb.append(LINE_SEPARATOR);
        }
        return sb.toString();
    }


    private void printMessage(final String message) {
        System.out.println(message);
    }
}

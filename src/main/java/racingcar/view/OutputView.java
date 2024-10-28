package racingcar.view;

import racingcar.dto.RacingResult;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_FORMAT = "%s : %s%n";
    private static final String FINAL_WINNER_FORMAT = "최종 우승자 : %s";

    public void printResult() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printWinners(String winners) {
        System.out.printf(FINAL_WINNER_FORMAT, winners);
    }

    public void printRacing(List<RacingResult> racingResults) {
        String result = racingResults.stream()
                .map(this::formatResult)
                .collect(Collectors.joining());
        System.out.println(result);
    }

    private String formatResult(RacingResult result) {
        return String.format(RACING_FORMAT, result.name(),
                getPositionDisplay(result.position()));
    }

    private String getPositionDisplay(int position) {
        return IntStream.rangeClosed(1, position)
                .mapToObj(element -> "-")
                .collect(Collectors.joining());
    }
}

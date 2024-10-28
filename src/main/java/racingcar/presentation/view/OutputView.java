package racingcar.presentation.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import racingcar.dto.RacingCarResponse;

public class OutputView {

    private static final String RESULT_DELIMITER = " : ";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printRacingCarResults(final RacingCarResponse response) {
        String racingCarResults = formatRacingCarResults(response);
        System.out.println(racingCarResults);
    }

    private String formatRacingCarResults(final RacingCarResponse response) {
        StringBuilder builder = new StringBuilder();
        appendResultGuide(builder);
        appendRaceResults(builder, response);
        appendWinnerNames(builder, response.winnerNames());
        return builder.toString();
    }

    private void appendResultGuide(final StringBuilder builder) {
        builder.append(LINE_SEPARATOR)
                .append("실행 결과")
                .append(LINE_SEPARATOR);
    }

    private void appendRaceResults(final StringBuilder builder, final RacingCarResponse response) {
        for (Map<String, Integer> raceResult : response.racingResults()) {
            appendRaceResult(builder, raceResult);
            builder.append(LINE_SEPARATOR);
        }
    }

    private void appendRaceResult(final StringBuilder builder, final Map<String, Integer> raceResult) {
        for (Entry<String, Integer> entry : raceResult.entrySet()) {
            String name = entry.getKey();
            String position = "-".repeat(entry.getValue());
            builder.append(joinWithResultDelimiter(name, position))
                    .append(LINE_SEPARATOR);
        }
    }

    private void appendWinnerNames(final StringBuilder builder, final List<String> winnerNames) {
        builder.append(joinWithResultDelimiter("최종 우승자", String.join(", ", winnerNames)));
    }

    private String joinWithResultDelimiter(final String front, final String back) {
        return String.join(RESULT_DELIMITER, front, back);
    }

}

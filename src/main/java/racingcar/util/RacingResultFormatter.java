package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingResult;

public class RacingResultFormatter {
    private static final String RACING_FORMAT = "%s : %s%n";

    private RacingResultFormatter() {    // 인스턴스화 방지
    }

    public static String format(List<RacingResult> results) {
        return results.stream()
                .map(RacingResultFormatter::formatSingleResult)
                .collect(Collectors.joining());
    }

    private static String formatSingleResult(RacingResult result) {
        return String.format(RACING_FORMAT, result.name(),
                formatPosition(result.position()));
    }

    private static String formatPosition(int position) {
        return "-".repeat(position);
    }
}
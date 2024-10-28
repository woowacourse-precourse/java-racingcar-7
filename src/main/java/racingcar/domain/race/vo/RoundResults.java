package racingcar.domain.race.vo;

import java.util.List;
import java.util.stream.Collectors;

public record RoundResults(List<RoundResult> roundResults) {

    private final static String NEW_LINE = "\n";

    @Override
    public String toString() {
        return roundResults.stream()
            .map(RoundResult::toString)
            .collect(Collectors.joining(NEW_LINE));
    }
}

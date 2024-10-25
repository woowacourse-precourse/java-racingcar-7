package racingcar.dto;

import java.util.List;
import racingcar.domain.Round;

public record TotalRoundResult(List<RoundResult> roundResults) {
    public static TotalRoundResult from(List<Round> rounds) {
        return new TotalRoundResult(rounds.stream()
                .map(RoundResult::from)
                .toList());
    }
}

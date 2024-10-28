package racingcar.domain.race.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record RaceResult(List<RoundResults> rounds) {

    private final static String DOUBLE_NEW_LINE = "\n\n";
    public RaceResult() {
        this(new ArrayList<>());
    }

    public void addRound(RoundResults roundResults) {
        rounds.add(roundResults);
    }

    @Override
    public String toString() {
        return rounds.stream()
            .map(RoundResults::toString)
            .collect(Collectors.joining(DOUBLE_NEW_LINE));
    }
}

package racingcar.domain.round;

import java.util.List;
import racingcar.domain.racer.Racer;

public record RoundSnapshot(List<RoundResult> roundResult, int maxPosition) {

    public static RoundSnapshot from(List<Racer> racers) {
        List<RoundResult> roundResult = racers.stream()
                .map(Racer::toRoundResult)
                .toList();

        return new RoundSnapshot(roundResult, extractMaxPosition(roundResult));
    }

    private static int extractMaxPosition(List<RoundResult> roundResult) {
        return roundResult.stream()
                .mapToInt(RoundResult::position)
                .max()
                .orElse(0);
    }

}

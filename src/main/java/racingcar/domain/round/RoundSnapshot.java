package racingcar.domain.round;

import java.util.List;
import racingcar.domain.racer.Racer;

public record RoundSnapshot(List<RoundResult> roundResult) {

    public static RoundSnapshot from(List<Racer> racers) {
        List<RoundResult> roundResult = racers.stream()
                .map(Racer::toRoundResult)
                .toList();

        return new RoundSnapshot(roundResult);
    }

    private int extractMaxPosition() {
        return this.roundResult.stream()
                .mapToInt(RoundResult::position)
                .max()
                .orElse(0);
    }

    public List<String> getWinners() {
        int maxPosition = extractMaxPosition();

        return this.roundResult.stream()
                .filter(roundInfo -> roundInfo.position() == maxPosition)
                .map(RoundResult::carName)
                .toList();
    }

}

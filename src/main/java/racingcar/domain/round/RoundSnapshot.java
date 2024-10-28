package racingcar.domain.round;

import java.util.List;

public class RoundSnapshot {

    private final List<RoundResult> roundResult;

    private RoundSnapshot(List<RoundResult> roundResult) {
        this.roundResult = roundResult;
    }

    public static RoundSnapshot from(List<RoundResult> roundResult) {
        return new RoundSnapshot(roundResult);
    }

    public List<RoundResult> getRoundResult() {
        return this.roundResult;
    }

    private int extractMaxPosition() {
        return getRoundResult().stream()
                .mapToInt(RoundResult::position)
                .max()
                .orElse(0);
    }

    public List<String> getWinners() {
        int maxPosition = extractMaxPosition();

        return getRoundResult().stream()
                .filter(roundInfo -> roundInfo.position() == maxPosition)
                .map(RoundResult::carName)
                .toList();
    }

}

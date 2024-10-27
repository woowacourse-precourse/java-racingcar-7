package racingcar.domain.round;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RoundHistory {

    private final Map<Integer, RoundSnapshot> roundHistories;

    public RoundHistory() {
        this.roundHistories = new LinkedHashMap<>();
    }

    public void addRoundSnapshot(int round, RoundSnapshot snapshot) {
        this.roundHistories.put(round, snapshot);
    }

    public List<RoundResult> getRoundResult(int round) {
        return getRoundSnapShot(round).roundResult();
    }

    public List<String> getWinnersByRound(int round) {
        RoundSnapshot roundSnapShot = getRoundSnapShot(round);

        return roundSnapShot.roundResult()
                .stream()
                .filter(roundInfo -> roundInfo.position() == roundSnapShot.maxPosition())
                .map(RoundResult::carName)
                .toList();
    }

    private RoundSnapshot getRoundSnapShot(int round) {
        RoundSnapshot roundSnapshot = this.roundHistories.get(round);
        validateNullCheck(roundSnapshot);

        return roundSnapshot;
    }

    private static void validateNullCheck(RoundSnapshot roundSnapshot) {
        if (roundSnapshot == null) {
            throw new IllegalArgumentException();
        }
    }

}

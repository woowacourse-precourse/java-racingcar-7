package racingcar.domain.round;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RoundHistory {

    private final Map<Integer, RoundSnapshot> roundHistories;

    public RoundHistory() {
        this.roundHistories = new LinkedHashMap<>();
    }

    public void addRoundResult(int round, RoundSnapshot snapshot) {
        this.roundHistories.put(round, snapshot);
    }

    public List<RoundResult> getRoundResult(int round) {
        RoundSnapshot roundSnapshot = this.roundHistories.get(round);
        if (roundSnapshot == null) {
            throw new IllegalArgumentException();
        }

        return roundSnapshot.roundResult();
    }

}

package racingcar.domain;

import java.util.List;

public class RoundResult {
    private final int roundNumber;
    private final List<CarMovement> movements;

    public RoundResult(int roundNumber, List<CarMovement> movements) {
        this.roundNumber = roundNumber;
        this.movements = movements;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public List<CarMovement> getMovements() {
        return movements;
    }
}
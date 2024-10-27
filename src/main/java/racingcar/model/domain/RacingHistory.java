package racingcar.model.domain;

import racingcar.model.domain.vo.Distance;

public class RacingHistory {
    private final String carName;
    private final int roundNumber;
    private final Distance totalMovedDistance;

    public RacingHistory(String carName, int roundNumber, int totalMovedDistance) {
        this.carName = carName;
        this.roundNumber = roundNumber;
        this.totalMovedDistance = new Distance(totalMovedDistance);
    }

    public String getCarName() {
        return carName;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getTotalMovedDistance() {
        return totalMovedDistance.getValue();
    }
}

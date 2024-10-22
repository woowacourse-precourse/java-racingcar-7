package racingcar.dto;

public class RaceRequest {

    private final String[] carName;
    private final int roundCount;

    public RaceRequest(String[] carName, int roundCount) {
        this.carName = carName;
        this.roundCount = roundCount;
    }

    public String[] getCarName() {
        return carName;
    }

    public int getRoundCount() {
        return roundCount;
    }
}

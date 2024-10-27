package racingcar.dto;

public class RaceRequest {
    private String carInput;
    private int tryCount;

    public RaceRequest(String carInput, int tryCount) {
        this.carInput = carInput;
        this.tryCount = tryCount;
    }

    public String getCarInput() {
        return carInput;
    }

    public int getTryCount() {
        return tryCount;
    }
}

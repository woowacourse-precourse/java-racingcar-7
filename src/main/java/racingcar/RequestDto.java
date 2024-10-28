package racingcar;

public class RequestDto {
    private String[] carNames;
    private int tryCount;

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }

    public RequestDto(String[] carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }
}

package racingcar.domain;

public class MoveForwardHistory {

    private String carName;
    private int goCount;

    public MoveForwardHistory(String carName, int goCount) {
        this.carName = carName;
        this.goCount = goCount;
    }

    public void updateGoCount() {
        this.goCount += 1;
    }

    public String getCarName() {
        return carName;
    }

    public int getGoCount() {
        return goCount;
    }
}

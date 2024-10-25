package racingcar.domain;

public class MoveForwardRecord {

    private String carName;
    private int goCount;

    public MoveForwardRecord(String carName, int goCount) {
        this.carName = carName;
        this.goCount = goCount;
    }

    public void updateGoCount(int num) {
        if (biggerThanThree(num)) {
            this.goCount += 1;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getGoCount() {
        return goCount;
    }

    private boolean biggerThanThree(int num) {
        return num > 3;
    }
}
package racingcar.domain;

public class RacingCar {

    private int cnt;
    private final String carName;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public int getCnt() {
        return cnt;
    }

    public String getCarName() {
        return carName;
    }

    public void increaseCnt() {
        cnt++;
    }
}

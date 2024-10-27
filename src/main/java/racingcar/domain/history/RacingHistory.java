package racingcar.domain.history;

import racingcar.domain.car.RacingCar;

public class RacingHistory extends RacingCar {

    public RacingHistory(String name, int distance) {
        super(name, distance);
    }

    // TODO : 이름 반환
    public String getRacingCarName() {
        return super.getName();
    }

    // TODO : 거리 반환
    public int getDistance() {
        return super.getDistance();
    }

    // TODO : 거리 출력 반환
    public String getPrintDistance() {
        return null;
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingController {
    private Car[] cars;

    public RacingController(Car[] cars) {
        this.cars = cars;
    }

    public void startRace() {
        for (Car car : cars) {
            car.incrementFowardCount(Randoms.pickNumberInRange(0, 9));
        }
    }
}

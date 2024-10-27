package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;

public class RaceController {
    private final int attemptCount;
    private final LinkedHashMap<Car, Integer> cars;

    public RaceController(LinkedHashMap<Car, Integer> cars, int attemptCount) {
        this.attemptCount = attemptCount;
        this.cars = cars;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

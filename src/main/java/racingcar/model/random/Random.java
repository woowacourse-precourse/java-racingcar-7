package racingcar.model.random;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.car.Car;

public class Random {
    public static void goRandomForward(Car car) {
        boolean forward = Random.randomBoolean();
        if (forward) {
            car.goForward();
        }
    }

    public static boolean randomBoolean() {
        final int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}

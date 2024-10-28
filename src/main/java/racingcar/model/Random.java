package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.model.Number.MIN_NUMBER;
import static racingcar.model.Number.MAX_NUMBER;
import static racingcar.model.Number.RESTRICT_NUMBER;


public class Random {

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public static void validRandomNumber(long number, CarInfo car) {
        if (number >= RESTRICT_NUMBER) {
            car.moveCount++;
        }
    }


}

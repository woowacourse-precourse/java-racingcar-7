package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGameUtility {

    public static void moveRacingCar(RacingCar car) {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            car.raiseMoveCount();
        }
    }
}

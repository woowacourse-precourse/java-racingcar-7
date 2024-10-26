package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementDecider {

    public static boolean checkMoveOrNot(){

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            return true;
        } else {
            return false;
        }

    }
}

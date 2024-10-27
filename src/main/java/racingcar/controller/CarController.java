package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;


public class CarController {
    private final int MOVEMENT_STANDARD = 4;
    public boolean canMove() {
        if(Randoms.pickNumberInRange(0,9) >= MOVEMENT_STANDARD) {
            return true;
        }
        return false;
    }
}

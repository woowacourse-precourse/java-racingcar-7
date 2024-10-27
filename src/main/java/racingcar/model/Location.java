package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Location {

    private int location;

    public void move() {
        if(canMove()) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

}

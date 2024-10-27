package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Movement {
    public boolean canMove(){
        final int canMoveStandard = 4;

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if(randomNumber >= canMoveStandard){
            return true;
        }else {
            return false;
        }
    }
}

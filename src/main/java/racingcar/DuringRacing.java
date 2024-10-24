package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class DuringRacing {

    public static int getMoveValue(){
        return Randoms.pickNumberInRange(0, 9);
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class DuringRacing {

    public static int getMoveValue(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean move(int goValue){
        return goValue > 3;
    }

}

package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MoveDecider {

    public static int pickRandomNum (){
        int randomNum = pickNumberInRange(0, 9);
        System.out.println(randomNum);
        return randomNum;
    }



}
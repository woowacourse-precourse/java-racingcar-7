package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MoveDecider {

    public static int pickRandomNum (){
        int randomNum = pickNumberInRange(0, 9);
        System.out.println(randomNum);
        return randomNum;
    }

    public static String isMovable(int randomNum) {
        String moved = "";
        if (randomNum > 3) {
            moved = moved + "-";
        }
        System.out.println(moved);
        return moved;
    }


}
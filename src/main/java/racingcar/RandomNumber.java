package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static int randomNum;

    static int randomNumber (){
        randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }

    public static int getRandomNum() {
        return randomNum;
    }
}

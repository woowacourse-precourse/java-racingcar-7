package racingcar.Input;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {

    public static int pickNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public static boolean random () {
        int K = pickNumber();
        if (K>=4) {
            return true;
        }
        return false;
    }

    public static void move () {

    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    public static int getRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static String getInputValue() {
        return Console.readLine();
    }
}

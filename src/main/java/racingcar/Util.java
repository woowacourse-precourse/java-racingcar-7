package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    public int getRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getInputValue() {
        return Console.readLine();
    }
}

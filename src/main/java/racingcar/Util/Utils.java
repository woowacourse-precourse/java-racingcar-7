package racingcar.Util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import racingcar.constants.NumberConstants;

public class Utils {

    public static ArrayList<String> splitNamesByComma(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER);
    }
}

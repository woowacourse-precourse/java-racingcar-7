package racingcar.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import racingcar.constants.NumberConstants;

public class Utils {

    public static ArrayList<String> splitNamesByComma(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public static StringBuilder getTotalMoveDistance(int moveDistance) {
        StringBuilder total = new StringBuilder();
        for (int i = 0; i < moveDistance; i++) {
            total.append("-");
        }
        return total;
    }
}

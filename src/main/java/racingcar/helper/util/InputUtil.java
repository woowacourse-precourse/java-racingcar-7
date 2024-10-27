package racingcar.helper.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.config.constant.io.InputConstant;
import racingcar.helper.validation.InputCountValid;
import racingcar.helper.validation.InputNameValid;


public class InputUtil {

    public static String inputCarNames() {
        String carNames = Console.readLine();
        InputNameValid.validInputString(carNames);

        return carNames;
    }

    public static List<String> splitCarNames(String carNames) {
        List<String> carNameList = List.of(carNames.split(InputConstant.DELIMITER));
        InputNameValid.validSplitInputString(carNameList);

        return carNameList;
    }

    public static int inputCount() {
        String inputCount = Console.readLine();
        InputCountValid.validTypeMissCount(inputCount);

        int count = Integer.parseInt(inputCount);
        InputCountValid.validRangeCount(count);

        return count;
    }
}

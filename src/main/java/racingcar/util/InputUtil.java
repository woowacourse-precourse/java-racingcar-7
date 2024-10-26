package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.InputCountValid;
import racingcar.validation.InputNameValid;


public class InputUtil {

    public static String inputCarNames() {
        String carNames = Console.readLine();
        InputNameValid.validEmptyName(carNames);
        InputNameValid.validDelimiterName(carNames);
        return carNames;
    }

    public static List<String> splitCarName(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        InputNameValid.validMultipleName(carNameList);
        InputNameValid.validLengthName(carNameList);
        InputNameValid.validDuplicateName(carNameList);
        return carNameList;
    }

    public static int inputCount() {
        String inputCount = Console.readLine();
        InputCountValid.validTypeMissCount(inputCount);
        int count = Integer.parseInt(inputCount);
        InputCountValid.validMoreCount(count);
        InputCountValid.validLessCount(count);
        return count;
    }
}

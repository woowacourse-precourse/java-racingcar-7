package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.InputValid;


public class InputUtil {

    public static String inputCarNames() {
        String carNames = Console.readLine();
        InputValid.validEmptyName(carNames);
        InputValid.validDelimiterName(carNames);
        return carNames;
    }

    public static List<String> splitCarName(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        InputValid.validMultipleName(carNameList);
        InputValid.validLengthName(carNameList);
        InputValid.validDuplicateName(carNameList);
        return carNameList;
    }
}

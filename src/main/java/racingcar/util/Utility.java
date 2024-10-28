package racingcar.util;

import static racingcar.util.Delimiter.COMMA;
import static racingcar.validator.Validator.validateCarCountLimit;
import static racingcar.validator.Validator.validateDuplicateCarName;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.Validator;

public class Utility {

    public static List<String> getSplitCarNames(String inputCarNames) {

        List<String> carNames = Arrays.stream(inputCarNames.split(COMMA.getDelimiter(), -1))
                .map(String::trim)
                .peek(Validator::validateAllCarNames)
                .toList();

        validateCarCountLimit(carNames);
        validateDuplicateCarName(carNames);

        return carNames;
    }


    public static boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }
}

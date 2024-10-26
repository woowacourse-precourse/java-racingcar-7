package racingcar.helper.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.config.constant.io.InputConstant;
import racingcar.config.constant.NumberConstant;
import racingcar.config.exception.input.name.DelimiterNameException;
import racingcar.config.exception.input.name.DuplicateNameException;
import racingcar.config.exception.input.name.EmptyNameException;
import racingcar.config.exception.input.name.LengthNameException;
import racingcar.config.exception.input.name.MultipleNameException;


public class InputNameValid {

    public static void validEmptyName(String carNames) {
        if (carNames.isEmpty()) {
            throw new EmptyNameException();
        }
    }

    public static void validDelimiterName(String carNames) {
        if (!carNames.contains(InputConstant.DELIMITER)) {
            throw new DelimiterNameException();
        }
    }

    public static void validInputString(String carNames) {
        validEmptyName(carNames);
        validDelimiterName(carNames);
    }

    public static void validMultipleName(List<String> carNameList) {
        if (carNameList.size() < NumberConstant.MIN_NAME_COUNT) {
            throw new MultipleNameException();
        }
    }

    public static void validLengthName(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > NumberConstant.SET_CAR_NAME_LENGTH) {
                throw new LengthNameException();
            }
        }
    }

    public static void validDuplicateName(List<String> carNameList) {
        Set<String> nameSet = new HashSet<>();
        for (String carName : carNameList) {
            if (!nameSet.add(carName)) {
                throw new DuplicateNameException();
            }
        }
    }

    public static void validSplitInputString(List<String> carNameList) {
        validMultipleName(carNameList);
        validLengthName(carNameList);
        validDuplicateName(carNameList);
    }
}

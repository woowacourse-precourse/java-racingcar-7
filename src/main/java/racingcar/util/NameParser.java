package racingcar.util;

import racingcar.domain.StringConstant;

import java.util.ArrayList;
import java.util.List;

public class NameParser {

    public List<String> parseCarNames(final String text) {
        List<String> result = new ArrayList<>();

        String[] carNames = text.split(StringConstant.NAME_DELIMITER.getValue());
        trimSpaces(result, carNames);

        return result;
    }

    private static void trimSpaces(List<String> result, String[] carNames) {
        for (String carName : carNames) {
            result.add(carName.trim());
        }
    }
}

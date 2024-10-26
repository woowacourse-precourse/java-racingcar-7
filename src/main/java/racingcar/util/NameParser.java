package racingcar.util;

import racingcar.domain.StringConstant;

import java.util.ArrayList;
import java.util.List;

public class NameParser {

    public List<String> carNameParse(final String text) {
        List<String> result = new ArrayList<>();

        String[] carNames = text.split(StringConstant.NAME_DELIMITER.getValue());
        for (String carName : carNames) {
            result.add(carName.trim());
        }
        return result;
    }
}

package racingcar.util;

import static racingcar.constant.Delimiter.COMMA;

public class Separator {
    public String[] separate(String carNames) {
        return carNames.split(COMMA.value());
    }
}

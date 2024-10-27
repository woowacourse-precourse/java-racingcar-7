package racingcar.domain;

import racingcar.utils.NumberGenerator;

public class AlwaysFourNumberGenerator implements NumberGenerator {
    public int generateInteger() {
        return 4;
    }
}

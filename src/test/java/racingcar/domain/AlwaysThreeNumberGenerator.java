package racingcar.domain;

import racingcar.utils.NumberGenerator;

public class AlwaysThreeNumberGenerator implements NumberGenerator {
    public int generateInteger() {
        return 3;
    }
}

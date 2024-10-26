package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class InputTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 공백_null_에러(String test) {
        Assertions.assertThatThrownBy(() -> new Input(test))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
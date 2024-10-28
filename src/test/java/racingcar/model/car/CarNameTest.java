package racingcar.model.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.Error.NAME_CANNOT_EXCEED_MAX_LENGTH;
import static racingcar.common.Error.NOT_NULL_OR_EMPTY_NAME;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567", "length"})
    void 이름_길이_예외_테스트(String carName) {
        assertThatThrownBy(() -> CarName.of(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_CANNOT_EXCEED_MAX_LENGTH.getMessage());
    }

    @Test
    void 이름_null_예외_테스트() {
        assertThatThrownBy(() -> CarName.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NULL_OR_EMPTY_NAME.getMessage());
    }

    @Test
    void 이름_빈값_예외_테스트() {
        assertThatThrownBy(() -> CarName.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NULL_OR_EMPTY_NAME.getMessage());
    }
}
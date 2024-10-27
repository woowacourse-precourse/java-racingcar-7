package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @DisplayName("이름의 길이가 5자를 넘으면 예외가 발생한다.")
    @Test
    void newCarNameWhenNameLengthExceed5IsThrowException() {
        //given
        String name = "123456";

        // when // then
        Assertions.assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5글자 이하만 가능합니다.");
    }

    @DisplayName("이름이 비워져 있으면 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void newCarNameWhenNameEmptyIsThrowException(String name) {
        // when // then
        Assertions.assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 필수입니다.");
    }
}
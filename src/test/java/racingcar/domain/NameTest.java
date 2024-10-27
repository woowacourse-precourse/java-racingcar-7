package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static racingcar.exception.ExceptionMessage.BLANK_NAME;
import static racingcar.exception.ExceptionMessage.OUT_OF_NAME_LENGTH;

public class NameTest {
    @ParameterizedTest
    @DisplayName("자동차 이름은 공백이 될 수 없다.")
    @ValueSource(strings = {" ", "", "\n", "    "})
    void validateBlank_Test(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefg", "minjun", "woowacourse"})
    @DisplayName("이름 길이는 5자 이하만 가능하다.")
    void validateLength_Test(String input){
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_NAME_LENGTH.getMessage());
    }
}

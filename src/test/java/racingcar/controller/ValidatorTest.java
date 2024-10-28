package racingcar.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator = new Validator();

    @DisplayName("이름 입력값이 쉼표로 구분되지 않으면 예외가 발생한다.")
    @Test
    void nameWithoutCommaThrowException() {
        assertThatThrownBy(() -> {
                    validator.checkDelimiter("name1name2");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    validator.checkDelimiter("name1name2");
                }).withMessageContaining("구분");
    }

    @DisplayName("이름 입력값이 쉼표로 구분되면 예외가 발생하지 않는다.")
    @Test
    void nameWithCommaNotThrowException() {
        assertDoesNotThrow(() -> validator.checkDelimiter("name1,name2"));
    }
}
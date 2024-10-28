package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.CarValidator.*;

class CarValidatorTest {

    @Test
    @DisplayName("이름이 null일 경우 예외를 발생시킨다.")
    void validateCarName_nullName_throwsException() {
        // given
        String nullName = null;

        // when & then
        assertThatThrownBy(() -> validateCarName(nullName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 null이거나 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 빈 문자열일 경우 예외를 발생시킨다.")
    void validateCarName_emptyName_throwsException() {
        // given
        String emptyName = "";

        // when & then
        assertThatThrownBy(() -> validateCarName(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 null이거나 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 최대 길이(5)를 초과할 경우 예외를 발생시킨다..")
    void validateCarName_nameTooLong_throwsException() {
        // given
        String longName = "abcdef";

        // when & then
        assertThatThrownBy(() -> validateCarName(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("이름이 유효할 경우 예외가 발생하지 않는다.")
    void validateCarName_validName_noException() {
        // given
        String validName = "car1";

        // when & then
        validateCarName(validName);
    }
}
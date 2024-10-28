package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.NamesInputValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesInputValidatorTest {

    @Test
    @DisplayName("',' 기준으로 이름 입력값 유효성 검사")
    void validateSuccess() {
        assertThatCode(() -> NamesInputValidator.validate("abc,hijk"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("',' 사이 공백 무관")
    void validateBlankSuccess() {
        assertThatCode(() -> NamesInputValidator.validate(" abc, hijk "))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 공백일 경우 예외 발생")
    void validateBlank() {
        assertThatThrownBy(() -> NamesInputValidator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 존재하지 않습니다");
    }

    @Test
    @DisplayName("차 이름이 1개일 경우 예외 발생")
    void validateOnlyOneName() {
        assertThatThrownBy(() -> NamesInputValidator.validate("ab/c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차는 최소 2대 이상이어야 합니다");
    }

    @Test
    @DisplayName("5자 이상의 이름이 존재할 경우 예외 발생")
    void validateLongNames() {
        assertThatThrownBy(() -> NamesInputValidator.validate("abcdefg,hijk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름은 5자를 초과할 수 없습니다");
    }
}
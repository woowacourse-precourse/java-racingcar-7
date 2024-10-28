package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("',' 사이에 공백은 제거하여 이름으로 저장")
    void validateBlankSuccess() {
        assertThatCode(() -> NamesInputValidator.validate(" abc, hijk "))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("5자 이상의 이름이 존재할 경우 예외 발생")
    void validateLongNames() {
        assertThatThrownBy(() -> NamesInputValidator.validate("abcdefg,hijk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름은 5자를 초과할 수 없습니다");
    }
}
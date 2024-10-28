package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesValidatorImplTest {

    private final CarNamesValidatorImpl validator = new CarNamesValidatorImpl();

    @Test
    @DisplayName("빈 값이나 공백을 입력하면 예외가 발생하는지 테스트")
    void 빈값_입력_테스트() {
        assertThatThrownBy(() -> validator.validate(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 이름 입력 시 예외 발생 테스트")
    void 중복이름_입력_테스트() {
        assertThatThrownBy(() -> validator.validate("pobi,woni,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복될 수 없습니다.");
    }
}
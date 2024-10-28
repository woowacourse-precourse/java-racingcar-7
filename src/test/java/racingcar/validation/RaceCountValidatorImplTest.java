package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceCountValidatorImplTest {

    private final RaceCountValidatorImpl validator = new RaceCountValidatorImpl();

    @Test
    @DisplayName("빈 값이나 공백 입력 시 예외 발생 테스트")
    void 빈값_입력_테스트() {
        assertThatThrownBy(() -> validator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주 횟수는 빈 값이나 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 시 예외 발생 테스트")
    void 숫자_아닌_입력_테스트() {
        assertThatThrownBy(() -> validator.validate("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주 횟수는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("경주 횟수가 1 미만일 때 예외 발생 테스트")
    void 경주_횟수_미만_예외_테스트() {
        assertThatThrownBy(() -> validator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주 횟수는 1 이상이어야 합니다.");
    }
}
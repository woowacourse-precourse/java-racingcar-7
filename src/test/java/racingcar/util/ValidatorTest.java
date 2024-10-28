package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외 발생")
    void validateCarNames_lengthExceeded() {
        List<String> carNames = List.of("pobi", "javajini");
        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 5글자가 넘습니다");
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우 예외 발생")
    void validateCarNames_duplicateNames() {
        List<String> carNames = List.of("pobi", "pobi");
        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("유효하지 않은 라운드 수가 입력될 경우 예외 발생")
    void validateRoundCount_invalidInput() {
        assertThatThrownBy(() -> Validator.validateRoundCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 정수를 입력해주세요.");
    }
}
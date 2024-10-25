package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"car, car2, 1", "12345,car, pobi1"})
    @DisplayName("쉼표를 기준으로 자른뒤, 앞뒤 공백을 제거한 이름을 대상으로 검사")
    void 자동차_이름_입력_검증_기능_테스트(String carNames) {
        assertDoesNotThrow(() -> Validator.validateCarNames(carNames));
    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi", "pobi,,java,,,jun", "pobi,"})
    @DisplayName("쉼표 이전, 이후로 이름이 존재해야만 유효")
    void 자동차_이름_입력_검증_예외_테스트(String carNames) {
        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "2147483647"})
    @DisplayName("자연수만 유효한 입력")
    void 시도_횟수_입력_검증_기능_테스트(String tryCount) {
        assertDoesNotThrow(() -> Validator.validateTryCount(tryCount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12afb23", "-123", "0"})
    @DisplayName("자연수가 아니라면 예외 처리")
    void 시도_횟수_입력_검증_예외_테스트(String tryCount) {
        assertThatThrownBy(() -> Validator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
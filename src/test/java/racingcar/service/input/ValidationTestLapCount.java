package racingcar.service.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTestLapCount {

    @Test
    @DisplayName("숫자가 아닌 다른 문자가 존재할 경우 예외 발생 테스트")
    void nonNumeric() {
        String lapCount = "1,";
        assertThatThrownBy(() -> Validation.lapCount(lapCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자가 존재할 경우 예외 발생 테스트 공백 문자")
    void nonNumeric2() {
        String lapCount = " 1";
        assertThatThrownBy(() -> Validation.lapCount(lapCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자가 존재할 경우 예외 발생 테스트 음수 표현")
    void nonNumeric3() {
        String lapCount = "-1";
        assertThatThrownBy(() -> Validation.lapCount(lapCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지나치게 큰 수 입력 시 예외 발생 테스트")
    void overflow() {
        String lapCount = String.valueOf(Long.MAX_VALUE + 1);
        assertThatThrownBy(() -> Validation.lapCount(lapCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수 0 일 경우 예외 발생 테스트")
    void zeroInput() {
        String lapCount = "0";
        assertThatThrownBy(() -> Validation.lapCount(lapCount)).isInstanceOf(IllegalArgumentException.class);
    }
}

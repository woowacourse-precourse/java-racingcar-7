package racingcar.service.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    @DisplayName("null 입력 시 예외 발생 테스트")
    void vacant() {
        String nullString = null;
        assertThatThrownBy(() -> Validation.carNames(nullString)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.lapCount(nullString)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 입력 시 예외 발생 테스트")
    void whitespace() {
        String whitespace = "";
        assertThatThrownBy(() -> Validation.carNames(whitespace)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.lapCount(whitespace)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백문자 입력 시 예외 발생 테스트1")
    void blank() {
        String blank = " ";
        assertThatThrownBy(() -> Validation.carNames(blank)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.lapCount(blank)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백문자 입력 시 예외 발생 테스트2")
    void blank2() {
        String blank = "  ";
        assertThatThrownBy(() -> Validation.carNames(blank)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.lapCount(blank)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("\\t 입력 시 예외 발생 테스트")
    void blank3() {
        String blank = "\t";
        assertThatThrownBy(() -> Validation.carNames(blank)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.lapCount(blank)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("\\n 입력 시 예외 발생 테스트")
    void blank4() {
        String blank = "\n";
        assertThatThrownBy(() -> Validation.carNames(blank)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.lapCount(blank)).isInstanceOf(IllegalArgumentException.class);
    }
}
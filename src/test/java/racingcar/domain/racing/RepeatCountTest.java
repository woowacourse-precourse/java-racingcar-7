package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RepeatCountTest {

    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생")
    void createRepeatCountWithEmptyThrowsException() {
        assertThatThrownBy(() -> new RepeatCount(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RepeatCount(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자연수가 아닐 시 예외 발생")
    void createRepeatCountWithExceedingFiveLengthThrowsException() {
        assertThatThrownBy(() -> new RepeatCount(" 123"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RepeatCount("asd"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RepeatCount("12 5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RepeatCount("12.3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RepeatCount("-10"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RepeatCount("123?"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RepeatCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 10만 이상일 시 예외 발생")
    void createRepeatCountWithHighNumberThrowsException() {
        assertThatThrownBy(() -> new RepeatCount("100000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

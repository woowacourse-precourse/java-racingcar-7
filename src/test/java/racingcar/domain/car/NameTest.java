package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("빈 문자열로 이름 생성 시 예외 발생")
    void createNameWithEmptyThrowsException() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5글자 초과 시 예외 발생")
    void createNameWithExceedingFiveLengthThrowsException() {
        assertThatThrownBy(() -> new Name("123 45"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("asdef."))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

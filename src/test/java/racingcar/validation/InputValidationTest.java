package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {
    @Test
    @DisplayName("이름을 입력받을 때 구분자가 없는 경우 예외발생")
    void validateDelimiter() {
        assertThatThrownBy(() -> new Race("abcdef", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름의 길이가 5자보다 큰 경우 예외발생")
    void validateNameLength() {
        assertThatThrownBy(() -> new Race("abcdef,java", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동횟수가 정수의 최대 값보다 큰 경우 예외발생")
    void validateIntRange() {
        assertThatThrownBy(() -> new Race("abcd,java", "10000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

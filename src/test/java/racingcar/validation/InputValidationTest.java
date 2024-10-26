package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {
    @Test
    @DisplayName("이름을 입력받을 때 구분자가 없는 경우 예외발생")
    void validateDelimiter() {
        assertThatThrownBy(() -> new Race("abcdef", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

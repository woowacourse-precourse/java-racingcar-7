package racingcar.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @DisplayName("빈 문자열만 자동차 이름으로 입력할 시 예외가 발생한다")
    @Test
    void emptyCarNameInput(){
        InputValidator im = new InputValidator();
        assertThatThrownBy(() -> {
            im.validateNameInput();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열만 입력하면 안됩니다.");
    }

    @DisplayName("양수가 아닌 값을 시도횟수로 입력하면 예외가 발상핸다")
    @Test
    void negativeAttemptNumberInput(){
        InputValidator im = new InputValidator();
        assertThatThrownBy(() -> {
            im.validateNumberInput();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수여야 합니다.");
    }
}

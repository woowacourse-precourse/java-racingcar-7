package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.AttemptCountValidator;

public class InputViewTest {

    @Test
    @DisplayName("Input이 숫자가 아닌 경우 IllegalArgumentExection을 발생시킨다.")
    void inputAttemptCount_Exception() {
        // given
        InputStream readLine = setReadLine("kia");
        System.setIn(readLine);

        String expectedMessage = "입력값은 숫자여야 합니다.";

        // when, then
        assertThatThrownBy(() -> InputView.inputAttemptCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @AfterEach
    void restoreSystemIn() {
        Console.close();
    }

    private void provideInput(String input) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다")
    void invalidTrialCountThrowsException() {
        provideInput("abc\n");

        assertThatThrownBy(InputView::getTrialCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("0 이하의 시도 횟수를 입력하면 예외가 발생한다")
    void zeroOrNegativeTrialCountThrowsException() {
        provideInput("0\n");

        assertThatThrownBy(InputView::getTrialCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }
}

package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.global.Message;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialInputTest {

    private final InputView inputViewValidator = new InputView();

    @Test
    void 시도_횟수_정상_입력_테스트() {
        String inputTrial = "3";
        inputViewValidator.validateInteger(inputTrial);
    }

    @Test
    void 시도_횟수_예외_입력_테스트() {
        String inputTrial = "pobi, javaji";
        assertThatThrownBy(() -> inputViewValidator.validateInteger(inputTrial))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.TRY_COUNT_NUMBER_ONLY.getMessage());
    }
}

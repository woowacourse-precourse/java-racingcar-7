package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.InputValidator;

class InputViewTrialCountTest extends NsTest {
    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView(new InputValidator());
    }

    @DisplayName("시도 횟수 입력을 받는다.")
    @ValueSource(strings = {"1", "23", "2147483647"})
    @ParameterizedTest
    void inputTrialCount(String input) {
        assertDoesNotThrow(() -> {
            run(input);
        });
    }

    @Override
    protected void runMain() {
        int trialCount = inputView.inputTrialCount();
        System.out.println(trialCount);
    }
}

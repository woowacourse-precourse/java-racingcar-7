package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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

    @DisplayName("0이하의 시도 횟수를 입력 받을 수 없다.")
    @ValueSource(strings = {"0", "-1", "-100", "-9999999999999999"})
    @ParameterizedTest
    void inputNegativeTrialCount(String input) {
        assertThatThrownBy(() -> {
            run(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값을 입력 받을 수 없다.")
    @ValueSource(strings = {" ", "숫자", "값", "number", "---"})
    @ParameterizedTest
    void inputNotNumberTrialCount(String input) {
        assertThatThrownBy(() -> {
            run(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        int trialCount = inputView.inputTrialCount();
        System.out.println(trialCount);
    }
}

package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Test
    void 시도_횟수_입력_검증_올바른_입력() {
        InputView inputView = new InputView();
        int actual = inputView.roundValidation(5);
        Assertions.assertThat(actual).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, -1, 0, -3})
    void 시도_횟수_입력_검증_예외(int number) {
        InputView inputView = new InputView();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.roundValidation(number));
    }
}
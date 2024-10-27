package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void 빈_문자열_입력시_예외가_발생한다() {
        // given
        String emptyInput = "";

        // when, then
        assertThatThrownBy(() -> inputView.validateNotBlank(emptyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_문자열_입력시_예외가_발생한다() {
        // given
        String blankInput = " ";

        // when, then
        assertThatThrownBy(() -> inputView.validateNotBlank(blankInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 총_라운드_수가_1_미만이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> inputView.validatePositiveRoundNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

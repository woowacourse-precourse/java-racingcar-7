package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

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
}

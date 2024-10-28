package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.common.exception.ErrorMessage.INPUT_BLANK_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private final InputStream originalInput = System.in;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    private void command(String input) {
        try {
            byte[] buf = String.join("\n", input).getBytes();
            System.setIn(new ByteArrayInputStream(buf));
        } finally {
            Console.close();
        }
    }

    @Test
    void 사용자는_콘솔을_통해_자동차_이름을_입력할_수_있다() {
        // given
        command("pobi,woni,jun");

        // when & then
        assertDoesNotThrow(inputView::inputCarNames);
    }

    @Test
    void 빈_이름이_입력되는_경우_예외_처리한다() {
        // given
        command(" ");

        // when & then
        assertThatThrownBy(() -> inputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_BLANK_ERROR);

    }

    @Test
    void 사용자는_콘솔을_통해_경주를_시도할_횟수를_입력할_수_있다() {
        // given
        command("5");

        // when & then
        assertDoesNotThrow(inputView::inputTrialCount);
    }
}
package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class RacingInputViewTest {
    private final RacingInputView inputView = new RacingInputView();

    private void setInput(String string) {
        InputStream input = new ByteArrayInputStream(string.getBytes());
        System.setIn(input);
        Console.close();
    }

    @Test
    void carNamesBlankTest() {
        setInput("  ");

        assertThatThrownBy(inputView::getCarNames).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getCarNamesTest() {
        setInput("test,cars");

        assertThat(inputView.getCarNames()).containsExactly("test", "cars");
    }

    @Test
    void moveCountNotIntegerTest() {
        setInput("test,cars");

        assertThatThrownBy(inputView::getMoveCount).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getMoveCountTest() {
        setInput("123");

        assertThat(inputView.getMoveCount()).isEqualTo(123);
    }
}
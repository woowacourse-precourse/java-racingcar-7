package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @Test
    void 자동차_이름을_쉼표로_구분하여_입력할_수_있다() {
        String input = "pobi,woni";
        List<String> expectedNames = List.of("pobi", "woni");

        List<String> names = InputHandler.commaSeparator(input);

        assertThat(names).isEqualTo(expectedNames);
    }

    @Test
    void 자동차_이름은_빈_문자열일_수_없다() {
        String input = "pobi,,woni";

        assertThatThrownBy(() -> InputHandler.commaSeparator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_5자_이하만_허용된다() {
        String input = "pobi,woni,longname";

        assertThatThrownBy(() -> InputHandler.commaSeparator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
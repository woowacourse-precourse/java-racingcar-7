package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = "pobi,woni,kng")
    void 자동차이름_분리_테스트(String input) {

        InputHandler inputHandler = new InputHandler();
        List<String> carNames = inputHandler.splitCarNames(input);

        assertThat(carNames).containsExactly("pobi", "woni", "kng");
    }

}
package model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = "pobi,woni,kng")
    void 자동차이름_분리_테스트1(String input) {

        InputHandler inputHandler = new InputHandler();
        String[] carNames = inputHandler.splitCarNames(input);

        assertThat(carNames).containsExactly("pobi", "woni", "kng");
    }

    @ParameterizedTest
    @ValueSource(strings = "포비,가나,다라마바")
    void 자동차이름_분리_테스트2(String input) {

        InputHandler inputHandler = new InputHandler();
        String[] carNames = inputHandler.splitCarNames(input);

        assertThat(carNames).containsExactly("포비", "가나", "다라마바");
    }

    @ParameterizedTest
    @ValueSource(strings = "pobi,javaji")
    void 자동차이름_분리_테스트3(String input) {

        InputHandler inputHandler = new InputHandler();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputHandler.splitCarNames(input))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @ParameterizedTest
    @ValueSource(strings = "5")
    void 반복횟수_정수화_테스트1(String input) {

        InputHandler inputHandler = new InputHandler();
        assertSimpleTest(() ->
                assertThat(inputHandler.toInt(input)).isEqualTo(5)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = "-1")
    void 반복횟수_정수화_테스트2(String input) {

        InputHandler inputHandler = new InputHandler();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputHandler.toInt(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
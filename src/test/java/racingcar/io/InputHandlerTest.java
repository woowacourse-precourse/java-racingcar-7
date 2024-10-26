package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    private final InputHandler inputHandler = new InputHandler();

    @AfterEach
    protected final void printOutput() {
        Console.close();
    }

    @DisplayName("정상적인 자동차 이름이 입력된 경우 문자열 리스트를 반환한다")
    @Test
    void 정상적인_자동차_이름이_입력된_경우_문자열_리스트를_반환한다() {
        // given
        systemInput("pobi,woni,jun\n");

        // when
        List<String> carNames = inputHandler.getCarNames();

        // then
        assertThat(carNames).containsExactlyInAnyOrder(
                "pobi",
                "woni"
                , "jun"
        );
    }

    @DisplayName("빈 문자열의 경우 예외가 발생한다")
    @Test
    void 빈_문자열의_경우_예외가_발생한다() {
        // given
        systemInput("\n");

        // when // then
        assertThatThrownBy(inputHandler::getCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다섯자가 넘는 경우 예외가 발생한다")
    @Test
    void 다섯자가_넘는_경우_예외가_발생한다() {
        // given
        systemInput("123456\n");

        // when // then
        assertThatThrownBy(inputHandler::getCarNames)
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("공백이 중복되는 경우 예외가 발생한다")
    @Test
    void 공백이_중복되는_경우_예외가_발생한다() {
        // given
        systemInput("pobi,,woni,jun\n");

        // when // then
        assertThatThrownBy(inputHandler::getCarNames)
                .isInstanceOf(IllegalArgumentException.class);

    }

    private void systemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
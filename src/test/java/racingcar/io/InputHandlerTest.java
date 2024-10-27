package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest extends IOTest {
    private final InputHandler inputHandler = new InputHandler();

    @DisplayName("정상적인 자동차 이름이 입력된 경우 문자열 리스트를 반환한다")
    @Test
    void 정상적인_자동차_이름이_입력된_경우_문자열_리스트를_반환한다() {
        // given
        systemInput("pobi,woni,jun");

        // when
        List<String> carNames = inputHandler.getCarNames();

        // then
        assertThat(carNames).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }

    @DisplayName("빈 문자열의 경우 예외가 발생한다")
    @Test
    void 빈_문자열의_경우_예외가_발생한다() {
        // given
        systemInput("");

        // when // then
        assertThatThrownBy(inputHandler::getCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다섯자가 넘는 경우 예외가 발생한다")
    @Test
    void 다섯자가_넘는_경우_예외가_발생한다() {
        // given
        systemInput("123456");

        // when // then
        assertThatThrownBy(inputHandler::getCarNames)
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("공백이 중복되는 경우 예외가 발생한다")
    @Test
    void 공백이_중복되는_경우_예외가_발생한다() {
        // given
        systemInput("pobi,,woni,jun");

        // when // then
        assertThatThrownBy(inputHandler::getCarNames)
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("실행 횟수를 입력하면 int로 변횐된 round가 반환된다.")
    @Test
    void test() {
        // given
        systemInput("5");

        // when
        int round = inputHandler.getRound();

        // then
        assertThat(round).isEqualTo(5);
    }

    @DisplayName("실행 횟수가 빈 값이라면 예외가 발생한다")
    @Test
    void 실행_횟수가_빈_값이라면_예외가_발생한다() {
        // given
        systemInput("");

        // when // then
        assertThatThrownBy(inputHandler::getRound)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실행 횟수가 0보다 작거나 같다면 예외가 발생한다")
    @Test
    void 실행_횟수가_0보다_작거나_같다면_예외가_발생한다() {
        // given
        systemInput("0");

        // when // then
        assertThatThrownBy(inputHandler::getRound)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실행 횟수에 문자 입력시 예외가 발생한다")
    @Test
    void 실행_횟수에_문자_입력시_예외가_발생한다() {
        // given
        systemInput("1,");

        // when // then
        assertThatThrownBy(inputHandler::getRound)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
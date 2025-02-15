package racingcar.view;

import org.junit.jupiter.api.*;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("유효한 자동차 이름을 입력받을 수 있다")
    void askCarNames_validInput() {
        // given
        InputView inputView = new InputView(() -> "pobi,woni,jun");

        // when
        List<String> carNames = inputView.askCarNames();

        // then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생시킨다")
    void askCarNames_nameTooLong() {
        // given
        InputView inputView = new InputView(() -> "pobi,woni,ruudska6");

        // when & then
        assertThatThrownBy(inputView::askCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 수가 2대 미만이면 예외를 발생시킨다")
    void askCarNames_lessThanTwoCars() {
        // given
        InputView inputView = new InputView(() -> "pobi");

        // when & then
        assertThatThrownBy(inputView::askCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주를 하기 위해서는 최소 2대 이상의 자동차가 필요합니다.");
    }

    @Test
    @DisplayName("시도 횟수로 양의 정수를 입력받을 수 있다")
    void askTryCount_validInput() {
        // given
        InputView inputView = new InputView(() -> "5");

        // when
        int tryCount = inputView.askTryCount();

        // then
        assertThat(tryCount).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수로 0 이하의 숫자를 입력하면 예외를 발생시킨다")
    void askTryCount_nonPositiveNumber() {
        // given
        InputView inputView = new InputView(() -> "0");

        // when & then
        assertThatThrownBy(inputView::askTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수를 입력해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수로 숫자가 아닌 값을 입력하면 예외를 발생시킨다")
    void askTryCount_nonNumericInput() {
        // given
        InputView inputView = new InputView(() -> "abc");

        // when & then
        assertThatThrownBy(inputView::askTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해야 합니다.");
    }

}

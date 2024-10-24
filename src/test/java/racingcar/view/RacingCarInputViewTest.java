package racingcar.view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarInputViewTest extends InputTest {

    @Test
    @DisplayName("inputCarNames는 입력에 맞는 자동차 이름 리스트를 정상적으로 반환한다.")
    void inputCarNames_ReturnCorrectly() {
        // given
        presetInput("a,bbb,ccccc");

        // when
        List<String> carNames = RacingCarInputView.inputCarNames();

        // then
        Assertions.assertThat(carNames)
                .hasSize(3)
                .contains(
                        "a",
                        "bbb",
                        "ccccc"
                );
    }

    @Test
    @DisplayName("inputTryCount는 입력 스트링을 int 값으로 변환하여 반환한다.")
    void inputTryCount_ReturnCorrectly() {
        // given
        presetInput("5");

        // when
        int tryCount = RacingCarInputView.inputTryCount();

        // then
        Assertions.assertThat(tryCount).isEqualTo(5);
    }

    @Test
    @DisplayName("inputTryCount는 Integer형으로 변환할 수 없는 수를 입력하면 IllegalArgumentException을 던진다.")
    void inputTryCount_WhenInputCantParseInteger_ThrowIllegalArgumentException() {
        // given
        presetInput("a");

        // when & then
        Assertions.assertThatThrownBy(RacingCarInputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("inputTryCount는 Integer 범위를 벗어난 수를 입력하면 IllegalArgumentException을 던진다.")
    void inputTryCount_WhenInputCantParseNumber_ThrowIllegalArgumentException() {
        // given
        presetInput("2147483648");

        // when & then
        Assertions.assertThatThrownBy(RacingCarInputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("inputTryCount는 0 이하의 수를 입력하면 IllegalArgumentException을 던진다.")
    void inputTryCount_WhenInputBelow0_ThrowIllegalArgumentException() {
        // given
        presetInput("0");

        // when & then
        Assertions.assertThatThrownBy(RacingCarInputView::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}

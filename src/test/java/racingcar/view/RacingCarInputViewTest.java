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
}

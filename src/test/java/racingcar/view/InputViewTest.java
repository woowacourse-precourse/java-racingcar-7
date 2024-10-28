package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Test
    @DisplayName("입력이 없는 경우")
    void 이름_입력_예외_테스트() {
        //given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("".getBytes()));

        //when & then
        assertThatThrownBy(inputView::readCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ㄱ", "#"})
    @DisplayName("시도할 횟수가 숫자가 아닌 경우")
    void 시도_횟수_입력_예외_테스트(String tryCount) {
        //given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(tryCount.getBytes()));

        //when & then
        assertThatThrownBy(inputView::readTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
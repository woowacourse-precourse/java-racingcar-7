package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends ConsoleOutputTestHelper {

    @Test
    @DisplayName("빈 줄(줄바꿈) 입력이 빈 문자열로 처리되는 예외 발생 테스트")
    void 빈_문자열_입력값_예외_테스트() {

        systemIn("\n");

        InputView inputView = new InputView();

        assertThatThrownBy(() -> {
                    inputView.readRacingCarNames();
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_INPUT.getMessage())
        ;
    }
}
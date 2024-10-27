package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("문자열을 ,를 기준으로 잘 분리하는지 테스트한다")
    void 문자열_분리_테스트() {
       InputView inputView = new InputView();

       Assertions.assertThat(inputView.seperatePlayers("pobi,woni,jun")).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다")
    void 시도횟수_1미만일_시_예외() {
        InputView inputView = new InputView();

        Assertions.assertThatThrownBy(() -> inputView.roundException(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수는 최소 한번 이상이어야 합니다");
    }

    @Test
    @DisplayName("마지막 자동차 이름 뒤에,로 끝날 시 예외가 발생한다")
    void 마지막_자동차_이름_뒤에_컴마_오면_예외_발생() {
        InputView inputView = new InputView();

        Assertions.assertThatThrownBy(() -> inputView.validEndWithComma("pobi,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(",를 마지막으로 입력하면 안됩니다");
    }

}

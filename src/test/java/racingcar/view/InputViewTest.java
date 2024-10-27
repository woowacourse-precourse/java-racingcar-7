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
}

package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameView;

public class UnitTest {

    @DisplayName("사용자가 정상적인 시도횟수를 입력한 경우")
    @Test
    public void testGetTrialCountValidInput() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RacingGameView view = new RacingGameView();

        int trialCount = view.getTrialCount();

        assertThat(trialCount).isEqualTo(5);
    }

    @DisplayName("사용자가 잘못된 시도횟수를 입력한 경우")
    @Test
    public void testGetTrialCountInvalidInput() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RacingGameView view = new RacingGameView();

        assertThatThrownBy(view::getTrialCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 숫자를 입력해주세요."); // 예외 메시지 검증
    }
}

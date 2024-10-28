package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RoundTest extends NsTest {

    @Test
    void 유효한_시도_횟수로_Round_객체를_생성한다() {
        final int validValue = 5;

        Round round = new Round(validValue);

        assertThat(round.value()).isEqualTo(validValue);
    }

    @Test
    void 시도_횟수가_0_이하일_때_예외가_발생한다() {
        final int invalidValue = 0;

        assertThatThrownBy(() -> new Round(invalidValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_음수일_때_예외가_발생한다() {
        final int negativeValue = -3;

        assertThatThrownBy(() -> new Round(negativeValue))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

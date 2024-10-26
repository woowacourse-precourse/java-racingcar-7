package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.exception.ErrorMessage.TRIAL_COUNT_TYPE_ERROR;
import static racingcar.common.exception.ErrorMessage.TRIAL_COUNT_ZERO_OR_NEGATIVE_VALUE_ERROR;

import org.junit.jupiter.api.Test;

class TrialCountTest {

    @Test
    void 시도_횟수를_정수로_변환할_수_없는_경우_예외_처리한다() {
        // given
        String trialCount = "%3";

        // when & then
        assertThatThrownBy(() -> TrialCount.from(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRIAL_COUNT_TYPE_ERROR);
    }

    @Test
    void 시도_횟수가_음수인_경우_예외_처리한다() {
        // given
        String trialCount = "-3";

        // when & then
        assertThatThrownBy(() -> TrialCount.from(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRIAL_COUNT_ZERO_OR_NEGATIVE_VALUE_ERROR);
    }
}
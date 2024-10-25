package racingcar.model.attemptcountinput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttemptCountValidationTest {
    @Test
    @DisplayName("시도할 횟수가 양수인지 확인한다")
    public void 시도할_횟수_양수_테스트() {
        int attemptCountNumber = AttemptCountValidation.attemptCountValidation("5");
        assertThat(attemptCountNumber).isEqualTo(5);
    }

    @Test
    @DisplayName("시도할 횟수가 0보다 작으면 오류를 발생시키는지 확인한다")
    public void 시도할_횟수_음수_테스트() {
        assertThatThrownBy(() -> AttemptCountValidation.attemptCountValidation("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
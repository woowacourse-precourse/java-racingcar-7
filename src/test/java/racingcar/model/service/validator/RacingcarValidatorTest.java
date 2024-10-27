package racingcar.model.service.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RacingcarValidatorTest {

    private final RacingcarValidator validator = new RacingcarValidator();

    @Test
    void 자동차_구분자_예외_테스트() {
        // given
        String carNamesInput = "pobi crong";
        String delimiter = ",";

        // when & then
        assertThatThrownBy(() -> validator.validateSplitCarNames(carNamesInput, delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    void 자동차_이름_길이_예외_테스트() {
        // given
        String carName = "pobi123";

        // when & then
        assertThatThrownBy(() -> validator.validateCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하이어야 합니다");
    }

    @Test
    void 시도횟수_숫자_변환_예외_테스트() {
        // given
        String attemptCountInput = "five";

        // when & then
        assertThatThrownBy(() -> validator.validateAttemptCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 시도횟수_1_미만_예외_테스트() {
        // given
        String attemptCountInput = "0";

        // when & then
        assertThatThrownBy(() -> validator.validateAttemptCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도횟수_최대값_이상_예외_테스트() {
        // given
        String attemptCountInput = "10001";

        // when & then
        assertThatThrownBy(() -> validator.validateAttemptCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 " + 10000 + " 이하이어야 합니다.");
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoundNumberValidatorTest {

    private RoundNumberValidator roundNumberValidator;

    @BeforeEach
    void setUp() {
        roundNumberValidator = new RoundNumberValidator();
    }

    @Test
    void 시도_횟수_1() {
        // given
        int roundNumber = 1;

        // when & then
        assertThatNoException()
                .isThrownBy(() -> roundNumberValidator.validateRoundNumber(roundNumber));
    }

    @Test
    void 시도_횟수_양수() {
        // given
        int roundNumber = 10;

        // when & then
        assertThatNoException()
                .isThrownBy(() -> roundNumberValidator.validateRoundNumber(roundNumber));
    }

    @Test
    void 시도_횟수_0() {
        // given
        int roundNumber = 0;

        // when & then
        assertThatThrownBy(() -> roundNumberValidator.validateRoundNumber(roundNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수_음수() {
        // given
        int roundNumber = -1;

        // when & then
        assertThatThrownBy(() -> roundNumberValidator.validateRoundNumber(roundNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수_MAX_VALUE() {
        // given
        int roundNumber = Integer.MAX_VALUE;

        // when & then
        assertThatNoException()
                .isThrownBy(() -> roundNumberValidator.validateRoundNumber(roundNumber));
    }
}
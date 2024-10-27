package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionMessage;
import racingcar.exception.RoundNumberRangeException;
import racingcar.exception.RoundTypeException;

public class RacingControllerTest {
    @ParameterizedTest
    @ValueSource(strings = {"일이삼", "123!", "round", "round123", "1.1", "-1"})
    void round_숫자_아닐_경우_예외(String round) {
        assertThatThrownBy(() -> {
            RacingController racingController = new RacingController("pobi, woni");
            racingController.setTotalRacingRound(round);
        }).isInstanceOf(RoundTypeException.class)
                .hasMessageContaining(ExceptionMessage.RACING_ROUND_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }

    @Test
    void round_양수_아닐_경우_예외() {
        assertThatThrownBy(() -> {
            RacingController racingController = new RacingController("pobi, woni");
            racingController.setTotalRacingRound("0");
        }).isInstanceOf(RoundNumberRangeException.class)
                .hasMessageContaining(ExceptionMessage.RACING_ROUND_POSITIVE_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }
}

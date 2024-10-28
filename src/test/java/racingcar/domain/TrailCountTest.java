package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.util.Message.ErrorMessage.NAME_MIN_LENGTH_ERROR;
import static racingcar.util.Message.ErrorMessage.NOT_A_NUMBER_ERROR;
import static racingcar.util.Message.ErrorMessage.TRIAL_MIN_COUNT_ERROR;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TrailCountTest {
    @Test
    @DisplayName("시도횟수가 잘 저장되는지에 대한 검증")
    void testValidTrialCount() {
        //given
        TrialCount trialCount = new TrialCount("5");
        //when
        //then
        assertEquals(5, trialCount.getAmount());
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값을 입력했을 경우")
    @ValueSource(strings = {"one", "12!!", "하나", ""})
    void testInvalidTrialCountNotANumber(final String inputString) {
        // given
        //when
        //then
        assertThatThrownBy(() -> new TrialCount(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_A_NUMBER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("최소 시도횟수 미만의 숫자를 입력했을 경우")
    @ValueSource(strings = {"-13", "0", "-1"})
    void testInvalidTrialCountBelowMinimum(final String inputString) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new TrialCount(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRIAL_MIN_COUNT_ERROR);
    }
}

package racingcar.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();
    
    @Test
    void validateCarNamesAndNumberOfCars_자동차이름은_두개_이상이어야한다() {
        // given
        String[] carNames = {"pobi"};
        
        // when & then
        assertThatThrownBy(
                () -> inputValidator.validateCarNamesAndNumberOfCars(carNames))
                .hasMessageContaining(ErrorMessage.NUMBER_OF_CAR_ERROR.getMessage());
    }

    @Test
    void validateCarNamesAndNumberOfCars_자동차이름은_최대_5자여야한다() {
        // given
        String[] carNames = {"pobi", "woni", "testname"};

        // when & then
        assertThatThrownBy(() -> inputValidator.validateCarNamesAndNumberOfCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
    }

    @Test
    void validateAttemptCount_시도횟수는_1이상이어야한다() {
        // given
        String round = "0";

        // when & then
        assertThatThrownBy(
                () -> inputValidator.validateAttemptCount(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ATTEMPT_COUNT_MINIMUM_ERROR.getMessage());
    }

    @Test
    void validateAttemptCount_정수가_아니면_예외를던진다() {
        // given
        String input = "invalid";

        // when & then
        assertThatThrownBy(
                () -> inputValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_ERROR.getMessage());
    }

    @Test
    void validateAttemptCount_정상적인_시도횟수_반환_성공() {
        // given
        String input = "5";

        // when
        int attemptCount = inputValidator.validateAttemptCount(input);

        // then
        assertThat(attemptCount).isEqualTo(5);
    }

}
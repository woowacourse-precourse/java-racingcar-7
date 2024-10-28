package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.validation.ErrorMessage.MINIMUM_RACING_TIME;
import static racingcar.validation.ErrorMessage.USER_INPUT_NOT_NULL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Winner;
import racingcar.utils.RandomNumber;
import racingcar.validation.Validator;

public class RacingServiceTest {

    private Winner winner = new Winner();
    private RandomNumber randomNumber = new RandomNumber();
    private Validator validator = new Validator();
    private RacingService racingService = new RacingService(winner, randomNumber, validator);

    @DisplayName("userStringInput에 'pobi,jisu,jenny'가 들어올 경우 테스트를 통과한다")
    @Test
    void user_string_input_success_case() {
        String userStringInput = "pobi,jisu,jenny";
        racingService.getValidatedStringInput(userStringInput);
    }

    @DisplayName("userStringInput이 공백일 경우, 예외를 발생시킨다")
    @Test
    void user_string_input_empty_then_throw_exception() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String userInput = "";
            racingService.getValidatedStringInput(userInput);
        });
        assertThat(exception.getMessage()).isEqualTo(USER_INPUT_NOT_NULL.getMessage());
    }

    @DisplayName("userIntegerInput이 '0'일 경우, 예외를 발생시킨다")
    @Test
    void user_integer_input_0_then_throw_exception() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String userInput = "0";
            racingService.getValidateIntegerInput(userInput);
        });
        assertThat(exception.getMessage()).isEqualTo(MINIMUM_RACING_TIME.getMessage());
    }

    @DisplayName("userIntegerInput에 1의자리, 10의자리, 100의 자리가 들어왔을 경우, 각 테스트는 성공한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100"})
    void user_integer_input_success_case(String userInput) {
        racingService.getValidateIntegerInput(userInput);
    }

}

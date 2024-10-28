package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.UserInputDto;

class UserInputValidatorTest {

    private final UserInputValidator userInputValidator = new UserInputValidator();

    @Test
    @DisplayName("정상입력 검증")
    void normalInputValidationTest() {
        String[] input = {"pobi,woni,jun", "5"};

        UserInputDto inputDto = userInputValidator.validate(input);

        assertThat(inputDto.carNames()).isEqualTo(List.of("pobi", "woni", "jun"));
        assertThat(inputDto.trialCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("초과 이름길이 검증")
    void abnormalNameValidationTest() {
        String[] input = {"pobiii,woni,jun", "5"};

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidator.validate(input));
        assertThat(exception.getMessage()).isEqualTo("이름의 길이는 1 ~ 5 만 허용합니다 : pobiii");
    }

    @Test
    @DisplayName("공백 이름 검증")
    void emptyNameValidationTest() {
        String[] input = {"", "5"};

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidator.validate(input));
        assertThat(exception.getMessage()).isEqualTo("이름의 길이는 1 ~ 5 만 허용합니다 : ");
    }

    @Test
    @DisplayName("중복 이름 검증")
    void duplicatedNameValidationTest() {
        String[] input = {"pobi,pobi,woni,jun", "5"};

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidator.validate(input));
        assertThat(exception.getMessage()).isEqualTo("중복된 이름은 사용할 수 없습니다");
    }

    @Test
    @DisplayName("음의 횟수 검증")
    void negativeTrialCountValidationTest() {
        String[] input = {"pobi,woni,jun", "-5"};

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidator.validate(input));
        assertThat(exception.getMessage()).isEqualTo("시도 횟수는 양의 정수만 가능합니다 : -5");
    }

    @Test
    @DisplayName("공백 횟수 검증")
    void emptyTrialCountValidationTest() {
        String[] input = {"pobi,woni,jun", ""};

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidator.validate(input));
        assertThat(exception.getMessage()).isEqualTo("시도 횟수는 양의 정수만 가능합니다 : ");
    }
}
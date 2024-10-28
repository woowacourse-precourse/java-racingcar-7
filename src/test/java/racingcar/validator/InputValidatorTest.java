package racingcar.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void validateCarNames_throwsExceptionWhenEmptyInput() {
        assertThatThrownBy(() -> inputValidator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 1개 이상의 자동차 이름을 입력해야 합니다.");
    }

    @Test
    void validateCarNames_throwsExceptionWhenMoreThanTenCars() {
        String input = "cara,carb,carc,card,care,carf,carg,carh,cari,carj,cark";
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 경주자 수는 10명입니다.");
    }

    @Test
    void validateCarNames_throwsExceptionWhenInvalidCarName() {
        String input = "cara,carb,car3";
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자의 소문자 알파벳으로 이루어져야 합니다.");
    }

    @Test
    void validateCarNames_throwsExceptionWhenCarNameIsTooLong() {
        String input = "cara,carb,abcdef";
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자의 소문자 알파벳으로 이루어져야 합니다.");
    }

    @Test
    void validateCarNames_passesWhenValidInput() {
        String input = "car,card,cars";
        inputValidator.validateCarNames(input); // 예외가 발생하지 않으면 성공
    }

    @Test
    void validateCarNames_throwsExceptionWhenCarNameContainsUppercase() {
        String input = "cara,Carb";
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자의 소문자 알파벳으로 이루어져야 합니다.");
    }

    @Test
    void validateCarNames_throwsExceptionWhenCarNameContainsSpecialCharacters() {
        String input = "car,car@";
        assertThatThrownBy(() -> inputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자의 소문자 알파벳으로 이루어져야 합니다.");
    }
}



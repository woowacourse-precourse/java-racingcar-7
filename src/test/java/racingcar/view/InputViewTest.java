package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.ValidationUtils;

public class InputViewTest {
    @Test
    @DisplayName("빈 문자열 입력 시 예외를 던진다")
    void shouldThrowExceptionWhenInputIsEmpty() {
        String input = "";
        String[] carNames = input.split(",");

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("이름이 공백인 경우 예외를 던진다")
    void shouldThrowExceptionWhenCarNameIsWhitespace() {
        String input = "Car1, ,Car3";
        String[] carNames = input.split(",");

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("이름에 특수 문자가 포함된 경우 예외를 던진다")
    void shouldThrowExceptionWhenCarNameContainsSpecialCharacters() {
        String input = "Car1,Car@2,Car3";
        String[] carNames = input.split(",");

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("자동차 이름이 너무 긴 경우 예외를 던진다")
    void shouldThrowExceptionWhenCarNameIsTooLong() {
        String input = "Car123456,Car2,Car3";
        String[] carNames = input.split(",");

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있는 경우 예외를 던진다")
    void shouldThrowExceptionWhenCarNamesAreDuplicated() {
        String input = "Car1,Car1,Car2";
        String[] carNames = input.split(",");

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("시도 횟수가 음수일 경우 예외를 던진다")
    void shouldThrowExceptionWhenTryCountIsNegative() {
        String input = "-5";

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateTryCount(Integer.parseInt(input));
        });
    }

    @Test
    @DisplayName("시도 횟수가 0일 경우 예외를 던진다")
    void shouldThrowExceptionWhenTryCountIsZero() {
        String input = "0";

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateTryCount(Integer.parseInt(input));
        });
    }

    @Test
    @DisplayName("시도 횟수가 너무 큰 경우 예외를 던진다")
    void shouldThrowExceptionWhenTryCountIsTooHigh() {
        String input = "1001";

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateTryCount(Integer.parseInt(input));
        });
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 값이 포함된 경우 예외를 던진다")
    void shouldThrowExceptionWhenTryCountIsNotANumber() {
        String input = "five";

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateTryCount(Integer.parseInt(input));
        });
    }

    @Test
    @DisplayName("자동차 이름이 null이 포함된 경우 예외를 던진다")
    void shouldThrowExceptionWhenCarNameIsNull() {
        String[] carNames = {null, "Car2", "Car3"};

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("자동차 이름 리스트에 빈 요소가 포함된 경우 예외를 던진다")
    void shouldThrowExceptionWhenCarNameListHasEmptyElements() {
        String input = "Car1,,Car3";
        String[] carNames = input.split(",");

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("자동차 이름에 숫자만 포함된 경우 유효")
    void shouldAllowCarNameWithOnlyNumbers() {
        String input = "123,456,789";
        String[] carNames = input.split(",");

        assertThat(carNames).containsExactly("123", "456", "789");
        ValidationUtils.validateCarNames(carNames);
    }

    @Test
    @DisplayName("구분자가 연속으로 존재하는 경우 예외를 던진다")
    void shouldThrowExceptionWhenDelimiterIsRepeated() {
        String input = "Car1,,Car2";
        String[] carNames = input.split(",");

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("자동차 이름이 한 글자만 포함된 경우 유효")
    void shouldAllowSingleCharacterCarNames() {
        String input = "A,B,C";
        String[] carNames = input.split(",");

        assertThat(carNames).containsExactly("A", "B", "C");
        ValidationUtils.validateCarNames(carNames);  // 예외가 발생하지 않아야 함
    }

}

package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("이름을 아무것도 입력하지 않았을 경우 예외가 발생한다.")
    @NullAndEmptySource
    void emptyInputNameException(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarName(name), "이름은 빈 값을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("이름이 5자를 초과할 경우 예외가 발생한다.")
    @ValueSource(strings = "pobibi")
    void inputCarNameOverLengthException(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarName(name), "이름의 길이가 5자를 초과합니다.");
    }

    @ParameterizedTest
    @DisplayName("이름이 영어로 이루어져 있지 않을 경우 예외가 발생한다.")
    @ValueSource(strings = "우테코")
    void inputCarNameNotEnglishException(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarName(name), "이름은 영어로만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("이름이 중복되었을 경우 예외가 발생한다.")
    @MethodSource("duplicateCarNames")
    void inputCarNameDuplicateException(List<String> names) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateCarNames(names), "중복된 이름은 사용할 수 없습니다.");
    }

    private static Stream<List<String>> duplicateCarNames() {
        return Stream.of(
                List.of("pobi", "pobi"),
                List.of("pobi", "woni", "pobi")
        );
    }

    @ParameterizedTest
    @DisplayName("시도 횟수를 아무것도 입력하지 않았을 경우 예외가 발생한다.")
    @NullAndEmptySource
    void emptyInputTryCountException(String count) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateTryCount(count), "시도 횟수는 빈 값을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("시도 횟수를 숫자가 아닌 값으로 입력했을 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "10a"})
    void inputTryCountNotNumberException(String count) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateTryCount(count), "시도 횟수는 숫자로만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("시도 횟수가 범위를 벗어났을 경우 예외가 발생한다.")
    @ValueSource(strings = {"11", "-1", "0"})
    void inputTryCountOutOfRangeException(String count) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateTryCount(count), "시도 횟수는 1부터 10까지 입력할 수 있습니다.");
    }

}

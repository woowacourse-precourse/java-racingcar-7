package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Nested
    @DisplayName("자동차 이름 유효성 검증")
    class ValidateCarNamesTest {

        @Test
        @DisplayName("자동차 이름이 없으면 예외가 발생한다")
        void validateEmptyNames() {
            String[] emptyNames = {};
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validateCarNames(emptyNames));
        }

        @Test
        @DisplayName("자동차 이름이 null이면 예외가 발생한다")
        void validateNullNames() {
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validateCarNames(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "   "})
        @DisplayName("자동차 이름이 빈 문자열이면 예외가 발생한다")
        void validateBlankName(String blankName) {
            String[] names = {blankName};
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validateCarNames(names));
        }

        @ParameterizedTest
        @ValueSource(strings = {"abcdef", "pobi123456"})
        @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
        void validateNameLength(String longName) {
            String[] names = {longName};
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validateCarNames(names));
        }

        @Test
        @DisplayName("자동차 이름이 중복되면 예외가 발생한다")
        void validateDuplicateNames() {
            String[] duplicateNames = {"pobi", "pobi"};
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validateCarNames(duplicateNames));
        }

        @Test
        @DisplayName("유효한 자동차 이름은 검증을 통과한다")
        void validateValidNames() {
            String[] validNames = {"pobi", "woni", "jun"};
            assertDoesNotThrow(() -> validator.validateCarNames(validNames));
        }
    }

    @Nested
    @DisplayName("시도 횟수 유효성 검증")
    class ValidateRoundsTest {

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -10})
        @DisplayName("시도 횟수가 0 이하면 예외가 발생한다")
        void validateNonPositiveRounds(int rounds) {
            assertThrows(IllegalArgumentException.class,
                    () -> validator.validateRounds(rounds));
        }

        @Test
        @DisplayName("유효한 시도 횟수는 검증을 통과한다")
        void validateValidRounds() {
            assertDoesNotThrow(() -> validator.validateRounds(5));
        }
    }
}

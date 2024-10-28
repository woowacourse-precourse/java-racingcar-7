package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.Exceptions;

import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {
    private CarNameValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CarNameValidator();
    }

    @DisplayName("빈 입력값 예외 테스트")
    @Test
    void validateNotBlankThrowsExceptionWhenInputIsBlank() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNamesInput(""),
                "빈 문자열에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_CAR_NAME_EMPTY.getMessage(), exception.getMessage());
    }

    @DisplayName("공백 포함 입력값 예외 테스트")
    @Test
    void validateNoSpaceThrowsExceptionWhenInputContainsSpace() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNamesInput("car1, car2,car3"),
                "공백 포함 입력에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_INPUT_WHITESPACE.getMessage(), exception.getMessage());
    }

    @DisplayName("쉼표로 끝나는 입력값 예외 테스트")
    @Test
    void validateEndThrowsExceptionWhenInputEndsWithDelimiter() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNamesInput("car1,car2,"),
                "쉼표로 끝나는 입력에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_INPUT_END.getMessage(), exception.getMessage());
    }

    @DisplayName("각 자동차 이름의 길이 제한 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"veryLongNameCar", "anotherLongCarName"})
    void validateCarNameLengthThrowsExceptionWhenNameExceedsMaxLength(String carName) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNamesInput(carName),
                "자동차 이름 길이 제한을 초과하는 입력에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_CAR_NAME_LENGTH.getMessage(), exception.getMessage());
    }

    @DisplayName("중복된 이름 예외 테스트")
    @Test
    void validateDuplicationThrowsExceptionWhenDuplicateNamesAreGiven() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNamesInput("car1,car2,car1"),
                "중복된 자동차 이름에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_CAR_NAME_DUPLICATION.getMessage(), exception.getMessage());
    }

    @DisplayName("유효한 입력값 테스트 - 예외 없음")
    @Test
    void validateCarNamesInputDoesNotThrowExceptionForValidInput() {
        assertDoesNotThrow(() -> validator.validateCarNamesInput("car1,car2,car3"));
    }
}

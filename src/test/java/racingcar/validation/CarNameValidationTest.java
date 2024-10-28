package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.*;

class CarNameValidationTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름이 null 이거나 빈 값일 수 없다")
    void validateNotNullOrEmptyTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_CANNOT_BE_NULL_OR_EMPTY.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("입력 시에 쉼표(,)로 2개 이상의 자동차들을 구분해야 한다.")
    void validateIncludeCommaTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_MUST_BE_SEPARATED_BY_COMMAS.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,"})
    @DisplayName("자동차 이름이 쉼표로 끝날 수 없다.")
    void validateNotEndWithCommaTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_CANNOT_END_WITH_COMMA.getMessage(), exception.getMessage());
    }


    @ParameterizedTest
    @ValueSource(strings = {"pobipobi, san"})
    @DisplayName("자동차 이름은 1~5 글자로 입력해야 한다.")
    void validateCarNameLengthTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_LENGTH_INVALID.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi"})
    @DisplayName("자동차 이름을 중복 입력할 수 없다.")
    void validateDuplicateNameTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(DUPLICATE_CAR_NAME_FOUND.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"po b   i,  s an "})
    @DisplayName("자동차 이름에 공백이 포함된 경우 공백을 제거한 후 실행")
    void carNameWithSpaceTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_MUST_BE_SEPARATED_BY_COMMAS.getMessage(), exception.getMessage());
    }

    private Throwable getValidate(String input) {
        return assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidation.validate(input);
        });
    }
}
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
    @DisplayName("자동차_이름이_null_이거나_빈_값일_수_없다")
    void validateNotNullOrEmptyTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_CANNOT_BE_NULL_OR_EMPTY.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("입력_시에_쉼표(,)로_2개_이상의_자동차들을_구분해야_한다.")
    void validateIncludeCommaTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_MUST_BE_SEPARATED_BY_COMMAS.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,"})
    @DisplayName("자동차_이름이_쉼표로_끝날_수_없다.")
    void validateNotEndWithCommaTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_CANNOT_END_WITH_COMMA.getMessage(), exception.getMessage());
    }


    @ParameterizedTest
    @ValueSource(strings = {"pobipobi, san"})
    @DisplayName("자동차_이름은_1~5_글자로_입력해야_한다.")
    void validateCarNameLengthTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(CAR_NAME_LENGTH_INVALID.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi"})
    @DisplayName("자동차_이름을_중복_입력할_수_없다.")
    void validateDuplicateNameTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(DUPLICATE_CAR_NAME_FOUND.getMessage(), exception.getMessage());
    }

    private Throwable getValidate(String input) {
        return assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidation.validate(input);
        });
    }
}
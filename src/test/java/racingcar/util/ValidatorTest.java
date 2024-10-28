package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private final Validator validator = Validator.getInstance();

    @Test
    public void 입력값_비어있을_경우_null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateEmptyString(null);
        });
        assertEquals(Constants.EMPTY_INPUT_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 입력값_비어있을_경우_빈문자열() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateEmptyString("");
        });
        assertEquals(Constants.EMPTY_INPUT_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 자동차_이름_5자_이하일_경우() {
        assertDoesNotThrow(() -> {
            validator.validateStringLength(Arrays.asList("aa", "bb", "cc"));
        });

    }

    @Test
    public void 자동차_이름_6자_이상일_경우() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateStringLength(Arrays.asList("aa", "bb", "ccccccccccccc"));
        });

        assertEquals(Constants.CAR_NAME_LENGTH_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 자동차_이름_중복x() {
        assertDoesNotThrow(() -> {
            validator.validateDuplicateName(Arrays.asList("aa", "bb", "cc"));
        });
    }

    @Test
    public void 자동차_이름_중복된_경우() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateDuplicateName(Arrays.asList("aa", "bb", "bb"));
        });
        assertEquals(Constants.DUPLICATE_CAR_NAME_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 자동차_이름_공백_없는_경우() {
        assertDoesNotThrow(() -> {
            validator.validateContainSpaceName(Arrays.asList("aa", "bb", "cc"));
        });
    }

    @Test
    public void 자동차_이름_공백_있는_경우() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateContainSpaceName(Arrays.asList("aa", "bb 2", "c   c"));
        });
        assertEquals(Constants.CAR_NAME_CONTAIN_SPACE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 자동차_이름_한글_또는_알파벳() {
        assertDoesNotThrow(() -> {
            validator.validateNameCharacters(Arrays.asList("가가", "aa", "가a", "a가"));
        });
    }

    @Test
    public void 자동차_이름_한글_또는_알파벳_이외의_값() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNameCharacters(Arrays.asList("가가", "123", "가!"));
        });
        assertEquals(Constants.CAR_NAME_CHARACTER_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 시도할_횟수_공백_없는_경우() {
        assertDoesNotThrow(() -> {
            validator.validateCountContainsSpace("5");
        });
    }

    @Test
    public void 시도할_횟수_공백_있는_경우() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCountContainsSpace("5  ");
        });
        assertEquals(Constants.COUNT_CONTAIN_SPACE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 시도할_횟수_정수값인_경우() {
        int result = validator.validateCountNonInteger("10");
        assertEquals(10, result);
    }

    @Test
    public void 시도할_횟수_정수값이_아닌_경우() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCountNonInteger("abc");
        });
        assertEquals(Constants.COUNT_NON_NUMBER_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void 시도할_횟수_1이상_양수값인_경우() {
        assertDoesNotThrow(() -> {
            validator.validateCountPositiveIntegerAboveOne(2);
        });
    }

    @Test
    public void 시도할_횟수_0이하_값인_경우() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCountPositiveIntegerAboveOne(0);
        });
        assertEquals(Constants.COUNT_ZERO_LESS_INTEGER_ERROR_MESSAGE, exception.getMessage());
    }
}

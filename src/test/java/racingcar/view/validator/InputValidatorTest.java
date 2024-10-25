package racingcar.view.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest{

    @Test
    void 자동차_한대_입력_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateSingleCar("kim"));
        assertEquals("자동차는 2개 이상 입력해주세요.", exception.getMessage());
    }

    @Test
    void 입력_문자열_공백_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateEmptyString(""));
        assertEquals("공백은 입력할 수 없습니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateEmptyString("  \n \t "));
        assertEquals("공백은 입력할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 시도할_횟수_양수_아니면_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validatePositiveNumber(0));
        assertEquals("1 이상의 정수만 입력가능합니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validatePositiveNumber(-123));
        assertEquals("1 이상의 정수만 입력가능합니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름이_공백이면_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateEmptyString(new String[]{"kim", "lee","    "}));
        assertEquals("공백은 입력할 수 없습니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateEmptyString(new String[]{"","lee","  ",""}));
        assertEquals("공백은 입력할 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름이_5글자_초과하면_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateCarNameLength(new String[]{"kim", "lee","     alpha    "}));
        assertEquals("자동차 이름은 1글자에서 5글자 사이로 입력가능합니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateCarNameLength(new String[]{"kim","lee","The Weeknd"}));
        assertEquals("자동차 이름은 1글자에서 5글자 사이로 입력가능합니다.", exception.getMessage());
    }

    @Test
    void 시도할_횟수가_숫자_형식이_아니면_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateTryCountFormat("%"));
        assertEquals("1 이상의 정수만 입력가능합니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> new InputValidator().validateTryCountFormat("  a   "));
        assertEquals("1 이상의 정수만 입력가능합니다.", exception.getMessage());
    }
}
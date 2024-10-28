package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputCarNamesValidatorTest {
    private final InputCarNamesValidator validator = new InputCarNamesValidator();

    @Test
    void Given_자동차_이름_When_CarNameLengthValid_호출시_Expect_True를_반환한다() {
        assertTrue(validator.isCarNameLengthValid("Car"));
    }

    @Test
    void Given_자동차_이름_When_CarNameLengthValid_호출시_Expect_예외를_발생시킨다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.isCarNameLengthValid("LongCarName");
        });
        assertEquals("이름의 길이가 5자를 초과한 유효하지 않은 이름입니다.", exception.getMessage());
    }

    @Test
    void Given_자동차_이름_When_isNotDuplicateCarName_호출시_True를_반환한다() {
        assertTrue(validator.isNotDuplicateCarName("Car1"));
    }

    @Test
    void Given_자동차_이름_When_isNotDuplicateCarName_호출시_Expect_예외를_발생시킨다() {
        validator.isNotDuplicateCarName("Car1");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.isNotDuplicateCarName("Car1");
        });
        assertEquals("자동차 이름이 중복되어 입력되었습니다.", exception.getMessage());
    }

    @Test
    void Given_자동차_이름_When_isNotCarNameEmpty_호출시_Expect_True를_반환한다() {
        assertTrue(validator.isNotCarNameEmpty("Car"));
    }

    @Test
    void Given_자동차_이름_When_isNotCarNameEmpty_호출시_Expect_예외를_발생시킨다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.isNotCarNameEmpty("");
        });
        assertEquals("공백이 입력되었습니다.", exception.getMessage());
    }
}

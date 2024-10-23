package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        this.validator = new Validator();
    }

    @DisplayName("랜덤 숫자가 4 이상인지 검증하는 기능 테스트")
    @Test
    public void isMoreFourTest() {
        assertFalse(validator.isMoreFour(1));
        assertFalse(validator.isMoreFour(2));
        assertFalse(validator.isMoreFour(3));
        assertTrue(validator.isMoreFour(4));
        assertTrue(validator.isMoreFour(5));
    }

    @DisplayName("차 이름 5자 이하인지 검증하는 기능 테스트")
    @Test
    public void validateCarNameTest() {
        assertFalse(validator.validateCarName("karina"));
        assertTrue(validator.validateCarName("pobi"));
    }
}

package racingcar.validationTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Validation;

public class ValidationTest {

    private Validation validation = new Validation();

    @Test
    @DisplayName("차 이름 입력 유효성 검사 테스트")
    public void validCarNameTest() {

        //given : this.validation

        //when & then
        // - right input case
        assertDoesNotThrow(() -> this.validation.validateCarNameInput("name1,name2,nm3,n4,5,CarNM"));
        assertDoesNotThrow(() -> this.validation.validateCarNameInput("name1"));

        // - wrong input case
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateCarNameInput(",name,name2"));
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateCarNameInput("name,,name2"));
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateCarNameInput("name,name2,"));
        assertThrows(IllegalArgumentException.class,
                () -> this.validation.validateCarNameInput("name_over_than_five,name"));
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateCarNameInput("sixcar"));
    }

    @Test
    @DisplayName("차수 개수 입력 유효성 검사 테스트")
    public void validRoundCountTest() {

        //given : this.validation

        //when & then
        // - right input case
        assertEquals(this.validation.validateRoundCount("5"), 5);
        assertEquals(this.validation.validateRoundCount("2147483647"), 2147483647);

        // - wrong input case
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateRoundCount("0"));
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateRoundCount("-10"));
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateRoundCount("c"));
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateRoundCount(" "));
        assertThrows(IllegalArgumentException.class,
                () -> this.validation.validateRoundCount("2147483648")); //over the int range
        assertThrows(IllegalArgumentException.class, () -> this.validation.validateRoundCount(null));
    }
}

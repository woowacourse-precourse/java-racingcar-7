package racingcar.service.validator.name;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNameLengthValidatorTest {
    private final InputNameLengthValidator inputNameLengthValidator = new InputNameLengthValidator();

    @Test
    @DisplayName("이름의 길이가 0이하 6이상일 시 IllegalArgumentException 던짐")
    void shouldThrowIllegalArgumentExceptionWhenInputNameLengthIsNegative() {

        //given
        String inputNames = "jihoismostStrongMan, jihoTheSexyGuy";

        //when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputNameLengthValidator.validate(inputNames));
    }
}
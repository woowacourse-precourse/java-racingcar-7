package racingcar.service.validator.name;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNameDuplicationValidatorTest {
    private final InputNameDuplicationValidator inputNameDuplicationValidator = new InputNameDuplicationValidator();

    @Test
    @DisplayName("중복된 이름이 있으면 IllegalArgumentException 던짐")
    void shouldThrowIllegalArgumentExceptionWhenDuplicatedNamesExist() {

        //given
        String duplicatedNames = "jiho,jiho,minsu";

        //when & then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputNameDuplicationValidator.validate(duplicatedNames));
    }

}
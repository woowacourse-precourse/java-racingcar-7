package racingcar.validationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingExceptionStatus;
import racingcar.validation.CarNameValidation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameValidationTest {

    @Test
    @DisplayName("올바른 차 이름 입력")
    void 시도_횟수_입력_성공(){

        List<String> names = new ArrayList<>();
        names.add(" name ");
        names.add("name");
        assertDoesNotThrow(() -> CarNameValidation.validate(names));
    }

    @Test
    @DisplayName("자동차 이름이 5자를 넘는 경우")
    void validate_carNameTooLong() {

        List<String> names = new ArrayList<>();
        names.add("LongName");
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    CarNameValidation.validate(names);
        });
        assertEquals(RacingExceptionStatus.INVALID_NAME_LENGTH.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열인 경우")
    void validate_carNameBlank() {

        List<String> names = new ArrayList<>();
        names.add("");

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    CarNameValidation.validate(names);
        });
        assertEquals(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 공백만 포함된 경우")
    void validate_carNameWithOnlySpace() {

        List<String> names = new ArrayList<>();
        names.add(" ");

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    CarNameValidation.validate(names);
        });
        assertEquals(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage(), exception.getMessage());
    }
}

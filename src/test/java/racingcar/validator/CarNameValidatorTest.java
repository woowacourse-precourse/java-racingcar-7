package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarRacingException;
import racingcar.exception.ErrorMessage;

public class CarNameValidatorTest {

    @Test
    @DisplayName("자동차 이름이 빈 문자열 또는 null일 때 예외 발생")
    void emptyOrNullName() {
        CarRacingException exception = assertThrows(CarRacingException.class, () -> CarNameValidator.validate(""));
        assert exception.getMessage().equals(ErrorMessage.EMPTY_CAR_NAME.getMessage());

        exception = assertThrows(CarRacingException.class, () -> CarNameValidator.validate(null));
        assert exception.getMessage().equals(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 예외 발생")
    void nameExceedsMaxLength() {
        CarRacingException exception = assertThrows(CarRacingException.class,
                () -> CarNameValidator.validate("abcdef"));
        assert exception.getMessage().equals(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 내부에 공백이 있을 때 예외 발생")
    void nameContainsInnerSpace() {
        CarRacingException exception = assertThrows(CarRacingException.class,
                () -> CarNameValidator.validate("po un"));
        assert exception.getMessage().equals(ErrorMessage.INVALID_CAR_NAME_SPACE.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있을 때 예외 발생")
    void duplicateNamesThrowsException() {
        List<String> carNames = Arrays.asList("pobi", "crong", "pobi");  // 중복된 이름 포함
        CarRacingException exception = assertThrows(CarRacingException.class, () -> CarNameValidator.validateNames(carNames));
        assert exception.getMessage().equals(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("유효한 자동차 이름 입력 시 예외 발생 x")
    void validName() {
        CarNameValidator.validate("pobi");
        CarNameValidator.validate("jun");
        CarNameValidator.validate("abcde");
    }
}

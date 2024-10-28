package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List<String> carNames = Arrays.asList("abcdef", "abcd");
        CarRacingException exception = assertThrows(CarRacingException.class,
                () -> CarNameValidator.validateNames(carNames));
        assert exception.getMessage().equals(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 내부에 공백이 있을 때 예외 발생")
    void nameContainsInnerSpace() {
        CarRacingException exception = assertThrows(CarRacingException.class,
                () -> CarNameValidator.validate("te st"));
        assert exception.getMessage().equals(ErrorMessage.INVALID_CAR_NAME_SPACE.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 내부 공백이 있을 때 예외 발생")
    void namesContainsInnerSpace() {
        List<String> carNames = Arrays.asList("pobi", " jung");
        CarRacingException exception = assertThrows(CarRacingException.class,
                () -> CarNameValidator.validateNames(carNames));
        assert exception.getMessage().equals(ErrorMessage.INVALID_CAR_NAME_SPACE.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있을 때 예외 발생")
    void duplicateNamesThrowsException() {
        List<String> carNames = Arrays.asList("pobi", "crong", "pobi");  // 중복된 이름 포함
        CarRacingException exception = assertThrows(CarRacingException.class,
                () -> CarNameValidator.validateNames(carNames));
        assert exception.getMessage().equals(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("유효한 자동차 이름 입력 시 예외 발생 x")
    void validName() {
        CarNameValidator.validate("pobi");
        CarNameValidator.validate("jun");
        CarNameValidator.validate("abcde");
    }

    @Test
    @DisplayName("자동차 이름 개수가 2개 미만 또는 1,000개 초과일 때 예외 발생")
    void invalidCarCountThrowsException() {
        List<String> tooFewCars = Arrays.asList("pobi");
        List<String> tooManyCars = new ArrayList<>(Collections.nCopies(1001, "car"));

        assertThrows(CarRacingException.class, () -> CarNameValidator.validateNames(tooFewCars));
        assertThrows(CarRacingException.class, () -> CarNameValidator.validateNames(tooManyCars));
    }

}

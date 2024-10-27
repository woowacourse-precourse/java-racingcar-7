package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarInputValidatorTest {
    private CarInputValidator carInputValidator;
    private HashSet<String> carsToCheckDuplicate;

    @BeforeEach
    void setup() {
        carInputValidator = new CarInputValidator();
        carsToCheckDuplicate = new HashSet<>();
    }

    @Test
    @DisplayName("초기 자동차 문자열이 비어있을 때 예외가 발생해야 한다.")
    void shouldThrowExceptionWhenAllCarInputIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                carInputValidator.checkIsAllInputEmpty("")
        );

        assert (exception.getMessage().contains(ErrorMessage.ERROR_IS_CAR_INPUT_EMPTY.getMessage()));
    }

    @Test
    @DisplayName("특정 자동차 이름이 빈 문자열일 때 예외가 발생해야 한다.")
    void shouldThrowExceptionWhenCarNameIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                carInputValidator.checkIsCarNameValid("", carsToCheckDuplicate)
        );

        assert (exception.getMessage().contains(ErrorMessage.ERROR_IS_CAR_NAME_EMPTY.getMessage()));
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과할 때 예외가 발생해야 한다.")
    void shouldThrowExceptionWhenCarNameIsTooLong() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                carInputValidator.checkIsCarNameValid("exceedFiveLetter", carsToCheckDuplicate)
        );

        assert (exception.getMessage().contains(ErrorMessage.ERROR_IS_CAR_NAME_TO_LONG.getMessage()));
    }

    @Test
    @DisplayName("자동차 이름이 중복될 때 예외가 발생해야 한다.")
    void shouldThrowExceptionWhenCarNameIsDuplicate() {
        carsToCheckDuplicate.add("car1");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                carInputValidator.checkIsCarNameValid("car1", carsToCheckDuplicate)
        );

        assert (exception.getMessage().contains(ErrorMessage.ERROR_IS_CAR_NAME_ALREADY_EXIST.getMessage()));
    }

    @Test
    @DisplayName("자동차 이름이 모든 조건을 만족할 때는 예외가 발생하지 않아야 한다.")
    void shouldNotThrowExceptionForValidCarName() {
        assertDoesNotThrow(() -> carInputValidator.checkIsCarNameValid("c", carsToCheckDuplicate));
        assertDoesNotThrow(() -> carInputValidator.checkIsCarNameValid("car1", carsToCheckDuplicate));
        assertDoesNotThrow(() -> carInputValidator.checkIsCarNameValid("car12", carsToCheckDuplicate));
    }

    @Test
    @DisplayName("자동차 입력값이 비어있지 않을 때 예외가 발생하지 않아야 한다.")
    void shouldNotThrowExceptionWhenAllCarInputIsNotEmpty() {
        assertDoesNotThrow(() -> carInputValidator.checkIsAllInputEmpty("car1, car2, car3"));
    }
}

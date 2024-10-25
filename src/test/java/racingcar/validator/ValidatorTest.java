package racingcar.validator;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.exception.IllegalArgumentException;

class ValidatorTest {

    @Test
    @DisplayName("자동차 이름 길이 예외 테스트")
    void validateCarNames() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Porsche"));
        cars.add(new Car("kia"));

        assertThatThrownBy(() -> Validator.validateCarNames(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_TOO_LONG.getMessage());
    }

    @Test
    @DisplayName("음수로 변환시 예외 테스트")
    void validateNegativeNumber() {
        assertThatThrownBy(() -> Validator.parseInteger("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ATTEMPT_COUNT_CANNOT_BE_ZERO.getMessage());
    }

    @Test
    @DisplayName("올바르지 않은 문자열 입력시 예외 발생")
    void validateInvalidString() {
        assertThatThrownBy(() -> Validator.parseInteger("one"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ATTEMPT_COUNT.getMessage());
    }

}
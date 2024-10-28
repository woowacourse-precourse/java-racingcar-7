package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.car.name.length.CarNameLengthValidatorImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameLengthValidatorImplTest {

    private final CarNameLengthValidatorImpl validator = new CarNameLengthValidatorImpl();

    @Test
    public void validate_ShouldThrowException_WhenCarNameIsTooLong() {
        String[] carNames = {"LongCarName"};

        assertThatThrownBy(() -> validator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름(LongCarName)이 너무 깁니다");
    }

    @Test
    public void validate_ShouldNotThrowException_WhenCarNamesAreWithinLimit() {
        String[] carNames = {"Car1", "Car2"};

        validator.validate(carNames); // 예외가 발생하지 않으면 테스트 통과
    }
}


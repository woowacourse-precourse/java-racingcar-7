package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.extractor.car.name.CarNameExtractorImpl;
import racingcar.validator.car.name.CarNameValidatorImpl;
import racingcar.validator.car.name.count.CarNameCountValidatorImpl;
import racingcar.validator.car.name.length.CarNameLengthValidatorImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameValidatorImplTest {

    private CarNameExtractorImpl carNameExtractor;
    private CarNameLengthValidatorImpl carNameLengthValidator;
    private CarNameCountValidatorImpl carNameCountValidator;
    private CarNameValidatorImpl carNameValidator;

    @BeforeEach
    public void setUp() {
        carNameExtractor = new CarNameExtractorImpl();
        carNameLengthValidator = new CarNameLengthValidatorImpl();
        carNameCountValidator = new CarNameCountValidatorImpl();
        carNameValidator = new CarNameValidatorImpl(carNameExtractor, carNameLengthValidator, carNameCountValidator);
    }

    @Test
    public void validate_ShouldPass_WhenInputIsValid() {
        String carNameString = "Car1,Car2";

        Assertions.assertDoesNotThrow(() -> carNameValidator.validate(carNameString));
        // 예외가 발생하지 않으면 테스트 통과
    }

    @Test
    public void validate_ShouldThrowException_WhenCarNameCountIsInvalid() {
        String carNameString = "Car1";

        assertThatThrownBy(() -> carNameValidator.validate(carNameString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 자동차의 개수가 2개 이상이여야 합니다.");
    }

    @Test
    public void validate_ShouldThrowException_WhenCarNameLengthIsInvalid() {
        String carNameString = "Car1,VeryLongCarName";

        assertThatThrownBy(() -> carNameValidator.validate(carNameString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름(VeryLongCarName)이 너무 깁니다");
    }
}

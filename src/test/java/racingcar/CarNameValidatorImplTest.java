package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.extractor.car.name.CarNameExtractorImpl;
import racingcar.validator.car.name.CarNameValidatorImpl;
import racingcar.validator.car.name.count.CarNameCountValidatorImpl;
import racingcar.validator.car.name.length.CarNameLengthValidatorImpl;

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

    @DisplayName("입력한 자동차 이름 문자열이 정상적으로 전체 유효성 검사를 통과하는지 Test")
    @Test
    public void validate_ShouldPass_WhenInputIsValid() {
        String carNameString = "Car1,Car2";

        Assertions.assertDoesNotThrow(() -> carNameValidator.validate(carNameString));
    }
}

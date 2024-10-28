package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.ErrorMessages.INVALID_CAR_COUNT;
import static racingcar.validator.ErrorMessages.INVALID_CAR_NAME_BLANK;
import static racingcar.validator.ErrorMessages.INVALID_CAR_NAME_DUPLICATE;
import static racingcar.validator.ErrorMessages.INVALID_CAR_NAME_LENGTH;
import static racingcar.validator.ErrorMessages.INVALID_ROUND_MINIMUM;
import static racingcar.validator.ErrorMessages.INVALID_ROUND_NOT_NUMBER;
import static racingcar.validator.ErrorMessages.INVALID_ROUND_OUT_OF_RANGE;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarNames;
import racingcar.validator.exception.InvalidCarCountException;
import racingcar.validator.exception.InvalidCarNameException;
import racingcar.validator.exception.InvalidRoundException;

class ValidatorFacadeTest {
    private ValidatorFacade validatorFacade;

    @BeforeEach
    void setUp() {
        Validator<CarNames> carNameValidator = new CarNameValidator();
        Validator<String> roundValidator = new RoundValidator();
        Validator<CarNames> carCountValidator = new CarCountValidator();
        validatorFacade = new ValidatorFacade(carNameValidator, roundValidator, carCountValidator);
    }

    @Test
    void 자동차_이름_검증_테스트() {
        CarNames validNames = new CarNames(Arrays.asList("car1", "car2", "car3"));
        validatorFacade.validateCarNames(validNames); // 예외가 발생하지 않으면 성공
    }

    @Test
    void 자동차_이름_공백일_때_예외_발생() {
        CarNames invalidNames = new CarNames(Arrays.asList("car1", " "));

        assertThatThrownBy(() -> validatorFacade.validateCarNames(invalidNames))
                .isInstanceOf(InvalidCarNameException.class)
                .hasMessage(INVALID_CAR_NAME_BLANK.getMessage());
    }

    @Test
    void 자동차_이름_길이가_기준을_넘었을_때_예외_발생() {
        CarNames invalidNames = new CarNames(Arrays.asList("longname"));

        assertThatThrownBy(() -> validatorFacade.validateCarNames(invalidNames))
                .isInstanceOf(InvalidCarNameException.class)
                .hasMessage(INVALID_CAR_NAME_LENGTH.getMessage(5));
    }

    @Test
    void 자동차_이름이_중복되었을_때_예외_발생() {
        CarNames invalidNames = new CarNames(Arrays.asList("car1", "car1", "car2"));

        assertThatThrownBy(() -> validatorFacade.validateCarNames(invalidNames))
                .isInstanceOf(InvalidCarNameException.class)
                .hasMessage(INVALID_CAR_NAME_DUPLICATE.getMessage());
    }

    @Test
    void 라운드_검증_테스트() {
        String validRound = "5";
        validatorFacade.validateRoundCount(validRound); // 예외가 발생하지 않으면 성공
    }

    @Test
    void 라운드가_숫자로_입력되지_않았을_때_예외_발생() {
        String invalidRound = "a";

        assertThatThrownBy(() -> validatorFacade.validateRoundCount(invalidRound))
                .isInstanceOf(InvalidRoundException.class)
                .hasMessage(INVALID_ROUND_NOT_NUMBER.getMessage());
    }

    @Test
    void 라운드_횟수가_1보다_작을_때_예외_발생() {
        String invalidRound = "-1";

        assertThatThrownBy(() -> validatorFacade.validateRoundCount(invalidRound))
                .isInstanceOf(InvalidRoundException.class)
                .hasMessage(INVALID_ROUND_MINIMUM.getMessage());
    }

    @Test
    void 라운드_횟수가_int_범위를_초과했을_때_예외_발생() {
        String invalidRound = "2147483648";

        assertThatThrownBy(() -> validatorFacade.validateRoundCount(invalidRound))
                .isInstanceOf(InvalidRoundException.class)
                .hasMessage(INVALID_ROUND_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 자동차_개수_검증_테스트() {
        CarNames validNames = new CarNames(Arrays.asList("car1", "car2"));
        validatorFacade.validateCarCount(validNames); // 예외가 발생하지 않으면 성공
    }

    @Test
    void 자동차_개수_1개_이하일_때_예외_발생() {
        CarNames invalidNames = new CarNames(Arrays.asList("car1")); // 개수 1개

        assertThatThrownBy(() -> validatorFacade.validateCarCount(invalidNames))
                .isInstanceOf(InvalidCarCountException.class)
                .hasMessage(INVALID_CAR_COUNT.getMessage());
    }
}

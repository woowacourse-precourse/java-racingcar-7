package racingcar;


import org.junit.jupiter.api.Test;
import racingcar.service.RacingGameService;
import racingcar.validation.Inputvalidator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExceptionTest {

    @Test
    void carNameValidate() {
        String cars = "ponyCar,choco,Amen";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Inputvalidator.validateCarNames(cars);
        }).withMessage("자동차 이름은 5자 이하여야 합니다.");
    }
}

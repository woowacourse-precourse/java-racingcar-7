package racingcar.validation;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarNameValidatorTest {
    @Test
    void 자동차_이름_6자_이상일_경우_예외() {
        List<String> carNames = List.of("pobi", "jun", "GyeongSoek");
        assertThatThrownBy(() -> CarNameValidator.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_5자_이하일_경우_정상() {
        List<String> carNames = List.of("pobi", "jun", "seok");
        assertThatCode(() -> CarNameValidator.validateCarNameLength(carNames))
                .doesNotThrowAnyException();
    }
}

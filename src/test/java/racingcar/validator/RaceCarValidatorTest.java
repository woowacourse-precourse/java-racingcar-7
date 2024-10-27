package racingcar.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceCarValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void 자동차_이름_길이_테스트(String carName) {
        assertThatThrownBy(() -> RaceCarValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

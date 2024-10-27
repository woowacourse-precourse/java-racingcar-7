package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"woowahan", "course", "racingcar"})
    void 자동차_이름이_최대_길이를_넘긴_경우_예외(String carName) {
        assertThatThrownBy(() -> new Name(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

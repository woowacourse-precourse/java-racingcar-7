package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {" ", "hwan22"})
    void 자동차_이름_검증(String value) {
        assertThatThrownBy(() -> new Car(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
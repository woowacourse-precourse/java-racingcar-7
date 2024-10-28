package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {" ", "hwan22"})
    void 자동차_이름_검증(String value) {
        assertThatThrownBy(() -> new CarName(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름생성() {
        CarName carName = new CarName("hwan2");
        assertThat(carName).isNotNull();
    }
}

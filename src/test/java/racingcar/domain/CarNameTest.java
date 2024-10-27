package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    void 공백() {
        Assertions.assertThatThrownBy(() -> CarName.of(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이() {
        Assertions.assertThatThrownBy(() -> CarName.of("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
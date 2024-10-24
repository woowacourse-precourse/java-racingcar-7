package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 이름은 5자 이하만 가능하다.")
    @Test
    void 자동차_이름_규칙_확인1() {
        Assertions.assertThatThrownBy(() -> new Car("자동차이름은"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
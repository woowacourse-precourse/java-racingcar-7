package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("규칙에 맞는 자동차 이름으로 자동차를 생성할 수 있다.")
    @Test
    void 자동차_생성_확인() {
        Car car1 = new Car("규칙준수");
        Car car2 = new Car("생성가능함");

        assertThat(car1).isNotNull();
        assertThat(car2).isNotNull();
    }

    @DisplayName("자동차 이름은 5자 이하만 가능하다.")
    @Test
    void 자동차_이름_규칙_확인() {
        assertThatThrownBy(() -> new Car("자동차이름은"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름을 지정한다")
    void carName() {
        //given
        String name = "pobi";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차의 초기화시 점수는 0점이다")
    void initPoint() {
        //given //when
        Car car = new Car("pobi");

        //then
        assertThat(car.getPoint()).isSameAs(0);
    }
}
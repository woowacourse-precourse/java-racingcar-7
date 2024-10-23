package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차는_전진할_수_있다() {
        //given
        Car car = new Car("test");

        //when
        car.forward();

        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }
}

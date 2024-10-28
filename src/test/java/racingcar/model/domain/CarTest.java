package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_전진_기능_테스트() {
        //given
        Car car = new Car("test");

        //when
        car.moveForward();

        //then
        assertThat(1)
                .isEqualTo(car.getMovedDistance());
    }

    @Test
    void 자동차_이름_예외_테스트() {
        //given
        String name = "hoyoung";

        //when,then
        assertThatThrownBy(
                () -> new Car(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}

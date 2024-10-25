package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 움직이는지_테스트() {
        //given
        Car car = new Car("bo");

        //when
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}

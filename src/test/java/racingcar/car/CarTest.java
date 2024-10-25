package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자돋차_이름_짓기() {
        //given
        String name = "test";
        Car car;

        //when
        car = new Car(name);

        //then
        assertThat(car.getName()).isEqualTo(name);
    }

}
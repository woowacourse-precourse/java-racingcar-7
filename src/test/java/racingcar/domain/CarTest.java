package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 차_객체_생성() {
        //given
        String name = "test";

        //when
        Car car = new Car("test");

        //then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getLocation()).isEqualTo(0);
        assertThat(car.toString()).isEqualTo("test : ");
    }

    @Test
    void 차_객체_전진() {
        //given
        String name = "test";
        Car car = new Car("test");

        //when
        car.move();

        //then
        assertThat(car.getLocation()).isEqualTo(1);
        assertThat(car.toString()).isEqualTo("test : -");
    }



}
package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getName_테스트() {
        // given
        Car car = new Car("dong");

        // when
        String name = car.getName();

        // then
        assertEquals(name, "dong");
    }

    @Test
    void getPosition_0_테스트() {
        // given
        Car car = new Car("dong");

        // when
        int position = car.getPosition();

        // then
        assertEquals(position, 0);
    }

    @Test
    void getPosition_1_테스트() {
        // given
        Car car = new Car("dong");
        car.moveIfPossible(4);

        // when
        int position = car.getPosition();

        // then
        assertEquals(position, 1);
    }

    @Test
    void getStatus_위치0_테스트() {
        // given
        Car car = new Car("dong");

        // when
        String initStatus = car.getStatus();

        // then
        assertEquals(initStatus, "dong : ");
    }

    @Test
    void getStatus_위치1_테스트() {
        // given
        Car car = new Car("dong");
        car.moveIfPossible(4);

        // when
        String status = car.getStatus();

        // then
        assertEquals(status, "dong : -");
    }

    @Test
    void moveIfPossible_정지_테스트() {
        // given
        Car car = new Car("dong");

        // when
        car.moveIfPossible(3);

        // then
        assertThat(car).extracting("position").isEqualTo(0);
    }

    @Test
    void moveIfPossible_이동_테스트() {
        // given
        Car car = new Car("dong");

        // when
        car.moveIfPossible(4);

        // then
        assertThat(car).extracting("position").isEqualTo(1);
    }

}
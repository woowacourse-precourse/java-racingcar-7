package service.vehicle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarTest {

    @DisplayName("자동차 이름을 가져온다.")
    @Test
    void getVehicleName() {
        //given
        Car car = new Car("dada");

        //when
        String name = car.getVehicleName();

        //then
        Assertions.assertThat(name).isEqualTo("dada");

    }
    @DisplayName("자동차 moveForwardCount를 가져온다.")
    @Test
    void move() {
        //given
        Car car = new Car("dada",5L);

        //when
        car.move();

        //then
        Assertions.assertThat(car.getMoveForwardCount()).isEqualTo(6L);

    }

    @DisplayName("자동차 moveForwardCount를 1증가시킨다.")
    @Test
    void getMoveForwardCount() {
        //given
        Car car = new Car("dada",5L);

        //when
        Long count = car.getMoveForwardCount();

        //then
        Assertions.assertThat(count).isEqualTo(5L);

    }


}
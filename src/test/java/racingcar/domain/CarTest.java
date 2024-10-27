package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("거리의 증가를 확인한다.")
    void updateDistance() {
        //given
        Car boye = new Car("boye", 0);
        Car sumin = new Car("sumin", 0);

        //when
        Car newboye = boye.updateDistance(boye, true);
        Car newsumin = sumin.updateDistance(sumin, false);

        //then
        assertThat(newboye.distance()).isEqualTo(1);
        assertThat(newsumin.distance()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름에 따른 초기 Car 객체를 만든다.")
    void make() {
        //given
        String name = "boye";
        Car expectCar = new Car("boye", 0);

        //when
        Car car = Car.make(name);

        //then
        assertThat(car).isEqualTo(expectCar);
    }

    @Test
    @DisplayName("이름의 예외사항이 있을 때 Car 객체를 만든다.")
    void makeWithException() {
        //given
        String name = "OhHyunji";

        Assertions.assertThatThrownBy(() -> Car.make(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
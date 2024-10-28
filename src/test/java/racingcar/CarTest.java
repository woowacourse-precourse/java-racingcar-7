package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {


    @Test
    void 이름길이가_5일시_Car_객체를_생성한다() {
        Car car = Car.from("다섯글자임");
        assertEquals("다섯글자임", car.getName());
    }

    @Test
    void 이름길이가_6일시_예외를_반환한다() {
        assertThrows(IllegalArgumentException.class, () ->
                Car.from("여서엇글자임"));
    }

    @Test
    void 이름이_빈칸일시_예외를_반환한다() {
        assertThrows(IllegalArgumentException.class, () ->
                Car.from(""));
    }

    @Test
    void 이름이_공백일시_예외를_반환한다() {
        assertThrows(IllegalArgumentException.class, () ->
                Car.from(" "));
    }

    @Test
    void 자동차의_처음위치는_0이다() {
        Car car = Car.from("name");
        assertEquals(0, car.getPosition());
    }

    @Test
    void 숫자4이상일경우_한_칸_전진한다() {
        Car car = Car.from("name");
        Car movedCar = car.moveForward(4);
        assertEquals(1, movedCar.getPosition());
    }

    @Test
    void 숫자4미만일경우_전진하지_못한다() {
        Car car = Car.from("name");
        Car movedCar = car.moveForward(3);
        assertEquals(0, movedCar.getPosition());
    }
}

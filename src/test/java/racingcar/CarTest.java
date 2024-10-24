package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {


    @Test
    void 이름길이가_5일시_Car_객체를_생성한다() {
        Car car = Car.from("다섯글자임");
        assertEquals("다섯글자임", car.toString());
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
    void 자동차_한_칸_전진한다() {
        Car car = Car.from("name");
        Car movedCar = car.moveForward();
        assertEquals(1, movedCar.getPosition());
    }

}

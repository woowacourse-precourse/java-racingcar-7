package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름이_5글자_초과할_경우_예외_발생() {
        // given
        String name = "여섯글자이름";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    void 자동차_이름_일치_테스트() {
        // given
        String name = "gyeom";
        Car car = new Car(name);

        // when & then
        assertEquals(name, car.getName());
    }

    @Test
    void 자동차_이동_후_위치_테스트() {
        // given
        String name = "gyeom";
        Car car = new Car(name);
        int movableNumber = 4;
        int immovableNumber = 3;

        // when
        car.moveFront(movableNumber);
        car.moveFront(movableNumber);
        car.moveFront(immovableNumber);
        car.moveFront(movableNumber);
        car.moveFront(immovableNumber);

        // then
        assertEquals(3, car.getPosition());
    }
}

package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름_생성_성공() {
        // given
        String name = "test";

        // when
        Car car = new Car(name);

        // then
        assertEquals(name, car.getName());
    }

    @Test
    void 자동차_이름_길이_실패() {
        // given
        String name = "testtesttesttesttest";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

}
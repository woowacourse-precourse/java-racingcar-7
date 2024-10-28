package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void 레이싱카_생성_테스트() {
        Assertions.assertEquals(3, Application.createCar("pobi,woni,jun").size());
        Assertions.assertEquals(2, Application.createCar("poi,,jun").size());
        Assertions.assertEquals(2, Application.createCar("poi, ,jun").size());

    }

    @Test
    void 레이싱카_생성_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Application.createCar(null));
        assertThrows(IllegalArgumentException.class, () -> Application.createCar(""));
        assertThrows(IllegalArgumentException.class, () -> Application.createCar(" "));
    }
}
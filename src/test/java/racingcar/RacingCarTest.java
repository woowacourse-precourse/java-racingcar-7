package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void 레이싱카_생성_테스트() {
        Assertions.assertEquals(3, RacingCar.createCar("pobi,woni,jun").size());
        Assertions.assertEquals(3, RacingCar.createCar("poi,irene,jun").size());
        Assertions.assertEquals(2, RacingCar.createCar("poi,,jun").size());
        Assertions.assertEquals(2, RacingCar.createCar("poi, ,jun").size());

    }

    @Test
    void 레이싱카_생성_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> RacingCar.createCar(null));
        assertThrows(IllegalArgumentException.class, () -> RacingCar.createCar(""));
        assertThrows(IllegalArgumentException.class, () -> RacingCar.createCar(" "));
        assertThrows(IllegalArgumentException.class, () -> RacingCar.createCar("pobi,olivia"));
    }

    @Test
    void 레이싱_횟수_예외_테스트() {
        List<Car> cars = RacingCar.createCar("poi,woni,jun");
        String attemptCount = "6회";
        assertThrows(IllegalArgumentException.class, () -> RacingCar.printRacing(attemptCount, cars));
    }
}
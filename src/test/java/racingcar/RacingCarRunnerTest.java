package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarRunnerTest {

    @DisplayName("자동차 정보 출력")
    @Test
    void printCar() {
        // given
        String carName = "pobi";
        // when
        RacingCar car = new RacingCar(carName);
        // then
        assertEquals("pobi : ", car.toString());
    }

    @DisplayName("한 칸 전진")
    @Test
    void carList() {
        // given
        String carName = "pobi";
        // when
        RacingCar car = new RacingCar(carName);
        car.moveForward();
        // then
        assertEquals("pobi : " + "-".repeat(1), car.toString());
    }
}
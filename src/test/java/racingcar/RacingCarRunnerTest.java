package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

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
    void moveForward() {
        // given
        String carName = "pobi";
        // when
        RacingCar car = new RacingCar(carName);
        car.moveForward();
        // then
        assertEquals("pobi : " + "-".repeat(1), car.toString());
    }

    @DisplayName("자동차 이름 5자 초과 시 예외 발생")
    @Test
    void nameException() {
        // given
        String carName = "abcdef";
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));
    }


}
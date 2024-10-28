package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RacingCar 모델 테스트")
class RacingCarTest {

    @Test
    @DisplayName("이동 시 Result Length가 1칸 올라가는지")
    void testMoveMethod() {
        // given
        RacingCar racingCar = new RacingCar("java");

        // when
        racingCar.move();

        // then
        assertEquals(1, racingCar.getRaceResultLength());
    }

    @Test
    @DisplayName("이동 후 result가 [이름] : --- 형태로 잘 출력 되는지")
    void resultOutPutTest() {
        // given
        RacingCar racingCar = new RacingCar("java");

        // when
        racingCar.move();

        // then
        assertEquals("java : -", racingCar.result());
    }
}

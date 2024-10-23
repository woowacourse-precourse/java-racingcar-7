package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarRunnerTest {

    @DisplayName("자동차 정보 출력")
    @Test
    void carList() {
        // given
        String carName = "pobi";
        int distance = Randoms.pickNumberInRange(0, 10);

        // when
        RacingCar car = new RacingCar(carName);
        car.setDistance(distance);

        // then
        assertEquals("pobi : " + "-".repeat(distance), car.toString());
    }

}
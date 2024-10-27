package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("전진 가능한 최솟값을 넘으면 자동차는 전진한다")
    void move_when_over_margin() {
        Car testCar = new Car("자동차");
        int randomNumber = Randoms.pickNumberInRange(4, 9);

        testCar.move(randomNumber);

        Assertions.assertEquals(testCar.getDistance(), 1);
    }

    @Test
    @DisplayName("전진 가능한 최솟값보다 작으면 자동차는 전진하지 않는다")
    void stop_when_under_margin() {
        Car testCar = new Car("자동차");
        int randomNumber = Randoms.pickNumberInRange(0, 3);

        testCar.move(randomNumber);

        Assertions.assertEquals(testCar.getDistance(), 0);
    }
}

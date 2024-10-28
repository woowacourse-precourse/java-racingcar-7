package racingcar;


import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarTest {

    @DisplayName("차 전진 랜덤 테스트")
    @Test
    void move() {
        Car car = new Car("전진");

        Assertions.assertRandomNumberInRangeTest(
            () -> {
                car.move();
                assertEquals(1, car.getPosition());
            },
            4
        );

    }
}

package racingcar;


import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import camp.nextstep.edu.missionutils.test.Assertions;


public class CarTest {

    @DisplayName("차 전진 랜덤 테스트")
    @Test
    void move() {
        Car car = new Car("전진");
        Assertions.assertRandomNumberInRangeTest(
            () -> {
                car.move();
                assertEquals(1,car.getPosition());
            },
            4
        );

    }
}

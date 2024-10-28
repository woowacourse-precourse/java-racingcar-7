package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("랜덤 값에 따라 이동 조건을 만족할 때 위치가 증가한다")
    void carMovesWhenConditionMet() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("poby");
                    car.move();
                    assertEquals(1, car.getPosition());
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("랜덤 값에 따라 이동 조건을 만족하지 않을 때 위치가 유지된다")
    void carDoesNotMoveWhenConditionNotMet() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("poby");
                    car.move();
                    assertEquals(0, car.getPosition());
                },
                STOP
        );
    }

    @Override
    public void runMain() {
    }
}

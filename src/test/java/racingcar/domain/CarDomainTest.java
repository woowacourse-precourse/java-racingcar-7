package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.constant.Constant.MOVE_FORWARD_RANGE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarDomainTest {
    private CarDomain car;

    @BeforeEach
    void setUp() {
        car = CarDomain.create("TestCar", 0);
    }

    @Test
    void testAttemptMove_WhenMoveIsAllowed() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.attemptMove();
                    assertEquals(1, car.getDistance());
                },
                MOVE_FORWARD_RANGE.min()
        );
    }

    @Test
    void testAttemptMove_WhenMoveIsNotAllowed() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.attemptMove();
                    assertEquals(0, car.getDistance());
                },
                MOVE_FORWARD_RANGE.min() - 1
        );
    }
}
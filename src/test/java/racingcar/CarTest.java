package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("name");
    }

    @Test
    void move() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.tryMove();
                    assertThat(car.getMoveCount()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void stop() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.tryMove();
                    assertThat(car.getMoveCount()).isEqualTo(0);
                },
                STOP
        );
    }

    @Override
    protected void runMain() {
    }
}
package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RandomEngineTest {
    private static final int MOVING_FOWARD = 1;
    private static final int STOP = 0;
    private RandomEngine randomEngine = new RandomEngine();

    @Test
    void 범위가_0이상_3이하면_움직이지_않는다() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertEquals(randomEngine.active(), STOP);
                },
                0, 3
        );
    }

    @Test
    void 범위가_4이상이면_움직인다() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertEquals(randomEngine.active(), MOVING_FOWARD);
                },
                4, 9
        );
    }

}
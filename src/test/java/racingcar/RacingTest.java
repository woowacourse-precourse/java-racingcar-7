package racingcar;

import org.junit.jupiter.api.Test;

public class RacingTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void testRunWithValidInput() {
        Racing racing = new Racing("pobi,woni");
        racing.run("3"); // 3번 시도
    }
}

package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

class WoowaGoMethodTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    static boolean canIGoResult;
    static WoowaGoMethod method;


    @BeforeAll
    static void setUpTest() {
        method = new WoowaGoMethod();
        canIGoResult = false;
    }

    @Test
    @DisplayName("랜덤 넘버가 기준값을 넘어 전진하는 경우 테스트")
    void goForwardCarTest()  {
        assertRandomNumberInRangeTest(
                this::runWoowaGoMethod,
                MOVING_FORWARD
        );

        Assertions.assertTrue(canIGoResult);
    }

    @Test
    @DisplayName("랜덤 넘버가 기준값을 넘지않아 전진하지 못하는 경우 테스트")
    void stopCarTest()  {
        assertRandomNumberInRangeTest(
                this::runWoowaGoMethod,
                STOP
        );

        Assertions.assertFalse(canIGoResult);
    }

    private void runWoowaGoMethod() {
        canIGoResult = method.canIGo();

    }
}
package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }
    @Test
    void 예외_테스트_길이() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void validateSizeOfCars() {
        String test = "pobi,woni,jun,woo";
        List<Car> cars = Application.createCars(test);
        assertThat(cars.size()).isEqualTo(4);
    }
    @Test
    void validatePositive() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun,woo", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void validateInteger() {
        String test = "5";
        int result = Application.validateInteger(test);
        assertThat(result).isEqualTo(5);
    }
    @Test
    void validateException_NotInteger() {
        assertThatThrownBy(() -> Application.validateInteger("abcd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

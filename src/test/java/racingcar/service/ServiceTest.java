package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.CarManager;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ServiceTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    Service service = new Service();

    @Test
    void operate() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("pobi : -", "pobi : --", "woni : -");
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        service.operate(List.of("pobi", "woni"), 2);
    }
}
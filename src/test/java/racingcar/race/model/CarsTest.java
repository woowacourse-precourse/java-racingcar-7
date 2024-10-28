package racingcar.race.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class CarsTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동자는_랜덤값이_4이상이면전진_4이하이면_멈춰있는_상태를_나타낸다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("mac, book", "1");
                    assertThat(output()).contains("mac : -", "book :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
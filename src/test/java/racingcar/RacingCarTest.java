package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertNowTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest extends NsTest {

    @Test
    void readUserInputTest() {
        assertSimpleTest(()->{
            RacingCar racingCar = new RacingCar();
            run("jsh", "1");
            racingCar.readUserInput();
            assertThat(racingCar.getCarNames()).isEqualTo("jsh");
            assertThat(racingCar.getNumOfTrial()).isEqualTo(1);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
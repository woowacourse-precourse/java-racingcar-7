package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertNowTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest extends NsTest {

    InputReader inputReader = new InputReader();
    RacingCar racingCar = new RacingCar(inputReader);

    GameEngine gameEngine = new GameEngine(inputReader, racingCar);
    @Test
    void readUserInputTest() {
        assertSimpleTest(()->{
            run("jsh", "1");
            gameEngine.readUserInput();
            assertThat(gameEngine.getCarNames()).isEqualTo("jsh");
            assertThat(gameEngine.getNumberOfTrial()).isEqualTo(1);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class GameRunnerTest extends NsTest {
    GameRunner gameRunner = new GameRunner();

    @Test
    void 자동차_전진_테스트() {
        assertSimpleTest(() -> {
            int randomValue = 4;
            boolean isMoved = gameRunner.isMoved(randomValue);
            assertThat(isMoved).isTrue();
        });
    }

    @Test
    void 자동차_멈춤_테스트() {
        assertSimpleTest(() ->{
            int randomValue = 1;
            boolean isMoved = gameRunner.isMoved(randomValue);
            assertThat(isMoved).isFalse();
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

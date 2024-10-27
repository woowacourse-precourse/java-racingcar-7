package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class GameRunnerTest extends NsTest {
    GameRunner gameRunner = new GameRunner();

    @Test
    void 자동차_전진_기능_테스트() {
        assertSimpleTest(() -> {
            int randomValue = 4;
            boolean isMoved = gameRunner.isMoved(randomValue);
            assertThat(isMoved).isTrue();
        });
    }

    @Test
    void 자동차_멈춤_기능_테스트() {
        assertSimpleTest(() ->{
            int randomValue = 1;
            boolean isMoved = gameRunner.isMoved(randomValue);
            assertThat(isMoved).isFalse();
        });
    }

    @Test
    void 우승자_판별_기능_테스트() {
        assertSimpleTest(() ->{
            Map<String, Integer> carState= new HashMap<>();
            carState.put("win", 4);
            carState.put("lose", 1);
            String winner = gameRunner.getWinner(carState);
            assertThat(winner).isEqualTo("win");
        });
    }

    @Test
    void 공동_우승자_기능_테스트() {
        assertSimpleTest(() ->{
            Map<String, Integer> carState= new HashMap<>();
            carState.put("win1", 4);
            carState.put("win2", 4);
            String winner = gameRunner.getWinner(carState);
            assertThat(winner).isEqualTo("win1, win2");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

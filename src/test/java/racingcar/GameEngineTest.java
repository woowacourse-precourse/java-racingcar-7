package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest extends NsTest {

    InputReader inputReader = new InputReader();
    GameEngine gameEngine = new GameEngine(inputReader);

    private static final int MOVING_FORWARD = 4;
    private static final int STOP =3;
    @Test
    void 올바른_사용자_입력_테스트() {
        Assertions.assertTimeoutPreemptively(Duration.ofDays(1), ()->{
            run("pobi,woni,jun", "1");
            gameEngine.readUserInput();
            assertThat(gameEngine.getCarNames()).isEqualTo("pobi,woni,jun");
            assertThat(gameEngine.getNumberOfTrial()).isEqualTo(1);
        });
    }
    @Test
    void 게임_초기화_테스트(){
        Assertions.assertTimeoutPreemptively(Duration.ofDays(1), ()->{
            run("pobi,woni,jun", "1");
            gameEngine.readUserInput();
            gameEngine.initializeGame();
            ArrayList<RacingCar> racingCars = gameEngine.getRacingCars();
            assertThat(racingCars.size()).isEqualTo(3);
            assertThat(racingCars.get(0).getCarName()).isEqualTo("pobi");
            assertThat(racingCars.get(1).getCarName()).isEqualTo("woni");
            assertThat(racingCars.get(2).getCarName()).isEqualTo("jun");
        });
    }

    @Override
    protected void runMain() {
        TestMain.main(new String[] {});
    }
}
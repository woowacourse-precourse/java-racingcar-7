package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.factory.GameFactory;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest extends NsTest {

    private GameController gameController;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        GameFactory gameFactory = new GameFactory();
        gameController = gameFactory.gameController();
    }

    @Test
    @DisplayName("게임을 실행하면 정상적으로 결과 출력까지 완료되어야 한다.")
    void run() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi2,woni", "1");
                    assertThat(output()).contains("pobi2 : -", "woni : ", "최종 우승자 : pobi2");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        gameController.run();
    }
}
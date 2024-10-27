package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Constants.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameLogicTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameLogic = new GameLogic();
        gameLogic.initialize(new String[]{"test1", "test2", "test3"});
    }

    @Test
    void 랜덤_값이_4_이상일_경우_전진한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    gameLogic.moveCarsIfQualified();
                    Map<String, StringBuilder> result = gameLogic.getResult();

                    assertThat(result.get("test1").toString()).isEqualTo(MOVE_INDICATOR);
                    assertThat(result.get("test2").toString()).isEqualTo("");
                    assertThat(result.get("test3").toString()).isEqualTo(MOVE_INDICATOR);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 가장_많이_전진한_최종_우승자를_구한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    // 이 부분은 인터페이스를 통해 모킹하여 사용하는 게 좋을 것 같다.
                    for (int i = 1; i <= 3; i++) {
                        gameLogic.moveCarsIfQualified();
                    }

                    List<String> winners = gameLogic.getWinners();
                    assertThat(winners).hasSize(1);
                    assertThat(winners.getFirst()).isEqualTo("test1");
                },
                MOVING_FORWARD, STOP, STOP,
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP
        );
    }
}

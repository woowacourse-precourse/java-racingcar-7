package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Constants.*;

import java.util.Map;
import java.util.stream.Collectors;
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
                    Map<String, StringBuilder> result = gameLogic.moveCarsIfQualified();

                    assertThat(result.get("test1").toString()).isEqualTo(MOVE_INDICATOR);
                    assertThat(result.get("test2").toString()).isEqualTo("");
                    assertThat(result.get("test3").toString()).isEqualTo(MOVE_INDICATOR);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}

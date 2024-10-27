package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Constants.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
        race.initialize(new String[]{"test1", "test2", "test3"});
    }

    @Test
    void 랜덤_값이_4_이상일_경우_전진한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    race.moveCarsIfQualified();
                    Map<String, StringBuilder> result = race.getResult();

                    assertThat(result.get("test1").toString()).isEqualTo(MOVE_INDICATOR);
                    assertThat(result.get("test2").toString()).isEqualTo("");
                    assertThat(result.get("test3").toString()).isEqualTo(MOVE_INDICATOR);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}

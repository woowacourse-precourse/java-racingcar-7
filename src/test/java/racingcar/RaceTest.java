package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
        race.register(new String[]{"test1", "test2", "test3"});
    }

    @Test
    void 랜덤_값이_4_이상일_경우_전진한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    race.moveCarsIfQualified();
                    List<Car> result = race.getResult();

                    assertThat(result.get(0).getMoving()).isEqualTo("-");
                    assertThat(result.get(1).getMoving()).isEqualTo("");
                    assertThat(result.get(2).getMoving()).isEqualTo("-");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}

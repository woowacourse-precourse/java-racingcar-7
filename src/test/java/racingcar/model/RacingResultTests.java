package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultTests extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int TOTAL_TRIAL_COUNT = 2;

    private RacingResult racingResult;

    @Override
    protected void runMain() {
        Racing racing = new Racing(List.of("alice", "bob", "john", "paul"));
        racing.start(TOTAL_TRIAL_COUNT);
        racingResult = new RacingResult(racing.getRacingRecord(), TOTAL_TRIAL_COUNT);
    }

    @Test
    @DisplayName("자동차 경주의 우승자가 여러 명일 경우")
    void testGetWinner() {
        List<String> expectedWinner = List.of("alice", "john");
        assertRandomNumberInRangeTest(
                () -> {
                    runMain();
                    assertThat(expectedWinner).isEqualTo(racingResult.getWinner());
                }, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }
}
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
    private static final int TOTAL_TRIAL_COUNT = 3;

    private RacingResult racingResult;

    @Override
    protected void runMain() {
        Racing racing = new Racing(List.of("alice", "bob", "john", "paul"));
        racing.start(TOTAL_TRIAL_COUNT);
        racingResult = new RacingResult(racing.getRacingRecord(), TOTAL_TRIAL_COUNT);
    }

    @Test
    @DisplayName("최종 우승자는 마지막 숫자 뽑기 종료 시점에서의 이동 거리를 기준으로 선정")
    void testFindSingleWinner() {
        List<String> expectedWinner = List.of("john");
        int expectedMaxDistance = 2;

        assertRandomNumberInRangeTest(
                () -> {
                    runMain();
                    assertThat(racingResult.findWinner()).isEqualTo(expectedWinner);
                    assertThat(racingResult.findMaxDistance()).isEqualTo(expectedMaxDistance);
                },
                STOP, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("최대 이동 거리를 갖는 자동차가 여러 대일 경우 최종 우승자는 여러 명")
    void testFindMultipleWinner() {
        List<String> expectedWinner = List.of("alice", "john");
        int expectedMaxDistance = 2;

        assertRandomNumberInRangeTest(
                () -> {
                    runMain();
                    assertThat(racingResult.findWinner()).isEqualTo(expectedWinner);
                    assertThat(racingResult.findMaxDistance()).isEqualTo(expectedMaxDistance);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}
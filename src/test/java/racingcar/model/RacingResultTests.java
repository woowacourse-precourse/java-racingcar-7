package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingController;

class RacingResultTests {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static List<String> inputNames;
    private static int totalTrialCount;

    private RacingResult racingResult;

    @BeforeAll
    static void setup() {
        inputNames = List.of("alice", "bob", "john", "paul");
        totalTrialCount = 2;
    }

    @Test
    @DisplayName("최종 우승자는 마지막 숫자 뽑기 종료 시점에서의 이동 거리를 기준으로 선정")
    void testFindSingleWinner() {
        List<String> expectedWinner = List.of("john");
        int expectedMaxDistance = 2;

        assertRandomNumberInRangeTest(
                () -> {
                    racingResult = RacingController.startRace(inputNames, totalTrialCount);
                    assertThat(racingResult.findMaxDistance()).isEqualTo(expectedMaxDistance);
                    assertThat(racingResult.findWinner()).isEqualTo(expectedWinner);
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
                    racingResult = RacingController.startRace(inputNames, totalTrialCount);
                    assertThat(racingResult.findMaxDistance()).isEqualTo(expectedMaxDistance);
                    assertThat(racingResult.findWinner()).isEqualTo(expectedWinner);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }
}
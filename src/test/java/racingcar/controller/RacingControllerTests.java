package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.dto.OutputDTO;
import racingcar.model.RacingCar;
import racingcar.model.RacingResult;

class RacingControllerTests extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("실행 결과에서의 이름의 순서가 최대 이동 거리에 관계없이 항상 입력 당시의 순서를 유지하는지 확인")
    void testNameOrderSameToInputOrder() {
        List<String> input = List.of("alice", "bob", "john");
        int inputTrialCount = 1;

        assertRandomNumberInRangeTest(
                () -> {
                    RacingResult result = RacingController.startRace(input, inputTrialCount);
                    OutputDTO output = RacingController.announceResult(result, inputTrialCount);
                    List<RacingCar> racingResult = output.getResult();
                    assertThat(racingResult).extracting(RacingCar::getName).containsSequence("alice", "bob", "john");
                },
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("이동 가능 횟수가 여러 번일 때, 마지막 실행 결과가 입력한 순서를 유지하면서 올바르게 출력되는지 확인")
    void testRaceResultOrderSameToInputOrder() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("alice, bob, john, paul", "2");
                    assertThat(output()).containsSubsequence("alice : --", "bob : -", "john : ", "paul : -");
                },
                MOVING_FORWARD, STOP, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("최종 우승자 출력 시, 출력되는 이름의 순서가 입력된 순서를 따르는지 확인")
    void testWinnerNameSameToInputOrder() {
        List<String> input = List.of("alice", "bob", "john", "paul");
        int inputTrialCount = 1;
        String expected = "alice, john";

        assertRandomNumberInRangeTest(
                () -> {
                    RacingResult result = RacingController.startRace(input, inputTrialCount);
                    OutputDTO output = RacingController.announceResult(result, inputTrialCount);
                    assertThat(output.getWinners()).isEqualTo(expected);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }
}
package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.dto.InputDTO;
import racingcar.dto.OutputDTO;
import racingcar.model.RacingCar;

class RacingControllerTests extends NsTest {

    private static final int TRIAL_COUNT = 1;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private List<String> input;

    @BeforeEach
    void setup() {
        input = List.of("alice", "bob", "john", "paul");
    }

    @Test
    @DisplayName("실행 결과 출력을 위해 나열된 이름들의 순서가 입력된 순서와 일치하는지 확인")
    void testNameOrderSameToInputOrder() {
        assertRandomNumberInRangeTest(
                () -> {
                    OutputDTO outputDTO = RacingController.execute(new InputDTO(input, TRIAL_COUNT));
                    assertThat(outputDTO.getRaceResult())
                            .extracting(RacingCar::getName)
                            .containsSequence("alice", "bob", "john", "paul");
                }, MOVING_FORWARD, STOP, STOP, STOP
        );
    }

    @Test
    @DisplayName("실행 결과가 올바르게 출력되었는지 확인")
    void testRaceResultOrderSameToInputOrder() {
        List<String> expected = List.of("alice : --", "bob : -", "john : ", "paul : -");
        assertRandomNumberInRangeTest(
                () -> {
                    run("alice, bob, john, paul", "2");
                    assertThat(output()).contains(String.join("\n", expected));
                },
                MOVING_FORWARD, STOP, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("최종 우승자 출력 시, 출력되는 이름의 순서가 입력된 순서를 따르는지 확인")
    void testWinnerNameSameToInputOrder() {
        assertRandomNumberInRangeTest(
                () -> {
                    OutputDTO outputDTO = RacingController.execute(new InputDTO(input, TRIAL_COUNT));
                    assertThat(outputDTO.getWinners()).isEqualTo("alice, john");
                }, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
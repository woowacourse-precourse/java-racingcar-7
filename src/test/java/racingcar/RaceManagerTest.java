package racingcar;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceManagerTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RaceManager raceManager = new RaceManager();

    @Test
    @DisplayName("자동차 경주 이동 1회 테스트 : 정상 입력")
    void Should_Pass_When_RaceOnceWithNormalInput() {
        assertRandomNumberInRangeTest(
                () -> {
                    Map<String, Integer> input = new HashMap<>();
                    input.put("pobi", 0);
                    input.put("woni", 0);

                    Map<String, Integer> expectedResult = new HashMap<>();
                    expectedResult.put("pobi", 0);
                    expectedResult.put("woni", 0);

                    Map<String, Integer> actualResult = raceManager.raceOnce(input);

                    assertThat(actualResult).isEqualTo(expectedResult);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("자동차 경주 우승자 탐색 테스트 : 정상 입력")
    void Should_Pass_When_FindWinnersWithNormalInput() {
        Map<String, Integer> input = new HashMap<>();
        input.put("pobi", 3);
        input.put("woni", 4);
        input.put("jun", 0);
        input.put("S", 1);
        input.put("b_man", 4);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("woni");
        expectedResult.add("b_man");

        List<String> actualResult = raceManager.findWinners(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}

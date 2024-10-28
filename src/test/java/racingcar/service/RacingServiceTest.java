package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingServiceTest {
    SetUpService setUpService = SetUpService.getInstance();
    RacingService racingService = RacingService.getInstance();

    @BeforeEach
    void setUpTest() {
        setUpService.setUpRace("pobi,woni,jun");
    }

    @Test
    @DisplayName("이동 횟수 한 번")
    void raceTest_oneTurn() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.race();

                    assertThat(racingService.getRaceProgress()).contains("pobi : -", "woni : -", "jun : ");
                },
                4, 9, 2
        );
    }

    @Test
    @DisplayName("이동 횟수 두 번")
    void raceTest_twoTurns() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.race();
                    racingService.race();

                    assertThat(racingService.getRaceProgress()).contains("pobi : --", "woni : -", "jun : -");
                },
                4, 9, 2, 5, 1, 8
        );
    }

    @Test
    @DisplayName("이동 횟수 세 번")
    void raceTest_threeTurns() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.race();
                    racingService.race();
                    racingService.race();

                    assertThat(racingService.getRaceProgress()).contains("pobi : ---", "woni : --", "jun : -");
                },
                4, 9, 2, 5, 1, 8
        );
    }
}

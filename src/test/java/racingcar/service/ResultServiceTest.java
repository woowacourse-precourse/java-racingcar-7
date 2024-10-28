package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultServiceTest {
    ResultService resultService = ResultService.getInstance();
    SetUpService setUpService = SetUpService.getInstance();
    RacingService racingService = RacingService.getInstance();

    @BeforeEach
    void setUpTest() {
        setUpService.setUpRace("pobi,woni,jun");
    }

    @Test
    @DisplayName("우승자 한 명")
    void getResultTest_oneWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.race();

                    assertEquals(resultService.getResult(), "pobi");
                },
                4, 3, 2
        );
    }

    @Test
    @DisplayName("우승자 두 명")
    void getResultTest_twoWinners() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.race();

                    assertEquals(resultService.getResult(), "pobi, woni");
                },
                4, 9, 2
        );
    }

    @Test
    @DisplayName("우승자 세 명")
    void getResultTest_threeWinners() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.race();

                    assertEquals(resultService.getResult(), "pobi, woni, jun");
                },
                4, 9, 5
        );
    }

}

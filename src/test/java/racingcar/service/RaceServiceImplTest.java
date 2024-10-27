package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.AppConfig;
import racingcar.model.RaceLog;

class RaceServiceImplTest {
    AppConfig appConfig = AppConfig.getInstance();

    @DisplayName("전진")
    @Test
    void runOneRaceRounds() {
        RaceService raceService = appConfig.getRaceService();
        raceService.setRaceCars("1번차,2번차,3번차");
        assertRandomNumberInRangeTest(
                () -> {
                    RaceLog raceLog1 = raceService.runRaceRounds(1).get(0);
                    RaceLog raceLog2 = raceService.runRaceRounds(1).get(0);

                    assertEquals(raceLog1.getRacerProgresses().get(0).generateString(), "1번차 : -");
                    assertEquals(raceLog1.getRacerProgresses().get(1).generateString(), "2번차 : ");
                    assertEquals(raceLog1.getRacerProgresses().get(2).generateString(), "3번차 : -");


                    assertEquals(raceLog2.getRacerProgresses().get(0).generateString(), "1번차 : -");
                    assertEquals(raceLog2.getRacerProgresses().get(1).generateString(), "2번차 : ");
                    assertEquals(raceLog2.getRacerProgresses().get(2).generateString(), "3번차 : --");
                }
                ,8, 3, 7, 1, 2, 9
        );
    }
}
package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.AppConfig;
import racingcar.model.RaceLog;

class RaceServiceImplTest {
    AppConfig appConfig;

    @BeforeEach
    void setUp() {
        appConfig = AppConfig.createNewInstance();
    }

    @DisplayName("전진")
    @Test
    void runOneRaceRounds() {
        RaceService raceService = appConfig.getRaceService();
        raceService.setRaceCars("1번차,2번차,3번차");
        assertRandomNumberInRangeTest(
                () -> {
                    RaceLog raceLog1 = raceService.executeRaceRounds(1).get(0);
                    RaceLog raceLog2 = raceService.executeRaceRounds(1).get(0);

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

    @DisplayName("중복이름 예외")
    @Test
    void validateDuplicateName() {
        RaceService raceService = appConfig.getRaceService();
        assertThrows(IllegalArgumentException.class, () -> raceService.setRaceCars("1번차,1번차,2번차"));
    }

    @DisplayName("긴이름 예외")
    @Test
    void validateLongName() {
        RaceService raceService = appConfig.getRaceService();
        assertThrows(IllegalArgumentException.class, () -> raceService.setRaceCars("1번차1번차,2번차"));
    }

    @DisplayName("빈 이름 예외")
    @Test
    void validateBlankName() {
        RaceService raceService = appConfig.getRaceService();
        assertThrows(IllegalArgumentException.class, () -> raceService.setRaceCars("1번차,,2번차"));
    }

    @DisplayName("양수 예외")
    @Test
    void validatePositive() {
        RaceService raceService = appConfig.getRaceService();
        assertThrows(IllegalArgumentException.class, () -> raceService.executeRaceRounds(-4));
    }

    @DisplayName("큰수 예외")
    @Test
    void validateBig() {
        RaceService raceService = appConfig.getRaceService();
        assertThrows(IllegalArgumentException.class, () -> raceService.executeRaceRounds(2_000_000));
    }
}
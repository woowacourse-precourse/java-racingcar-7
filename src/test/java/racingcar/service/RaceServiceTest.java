package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.util.FixedNumberGenerator;

public class RaceServiceTest {
    private static final int FORWARD = 1;
    private static final int STOP = 0;
    private ThresholdScoreRaceService raceService;

    @Test
    void 전진_테스트() {
        raceService = new ThresholdScoreRaceService(new FixedNumberGenerator(4));
        int result = raceService.determineMove();
        assertThat(result).isEqualTo(FORWARD);
    }

    @Test
    void 멈춤_테스트() {
        raceService = new ThresholdScoreRaceService(new FixedNumberGenerator(3));
        int result = raceService.determineMove();
        assertThat(result).isEqualTo(STOP);
    }
}

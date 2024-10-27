package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceResultDTO;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void beforeEach(){
        this.racingService = new RacingService();
    }

    @Test
    @DisplayName("startRace 로직이 정상 작동 되는지 확인")
    void startRace_로직이_정상_작동_되는지_확인(){
        String[] carNames = {"aa", "bb", "cc"};

        int trialCount = 3;

        RaceResultDTO result = racingService.startRace(carNames, trialCount);

        assertThat(result).isNotNull();
        assertThat(result.winner()).isNotEmpty();
        assertThat(result.raceProcedure().keySet()).hasSize(trialCount);
    }
}
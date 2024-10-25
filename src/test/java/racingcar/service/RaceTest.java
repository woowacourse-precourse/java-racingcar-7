package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingResult;

class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    @DisplayName("레이스 통합테스트")
    void startRaceTest() {
        String carNames = "pobi,woni,jun";
        String tryCount = "5";
        RacingResult result = race.start(carNames, tryCount);

        assertThat(result).isNotNull();
        assertThat(result.winnerResult()).isNotNull();
        assertThat(result.totalRoundResult().roundResults()).hasSize(Integer.parseInt(tryCount));
    }
}

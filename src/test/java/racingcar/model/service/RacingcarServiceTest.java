package racingcar.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.GameEnvironment;

class RacingcarServiceTest {

    private GameEnvironment gameEnvironment;
    private RacingcarService racingcarService;

    @BeforeEach
    void setUp() {
        gameEnvironment = new GameEnvironment();
        racingcarService = new RacingcarService(gameEnvironment);
    }

    @Test
    void 자동차_저장_성공_테스트() {
        // given
        String carNamesInput = "pobi,crong,honux";

        // when
        int result = racingcarService.saveCars(carNamesInput);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 시도횟수_저장_성공_테스트() {
        // given
        String attemptCountInput = "5";

        // when
        int result = racingcarService.saveAttemptCount(attemptCountInput);

        // then
        assertThat(result).isEqualTo(1);
        assertThat(gameEnvironment.getAttemptCount()).isEqualTo(5);
    }
}

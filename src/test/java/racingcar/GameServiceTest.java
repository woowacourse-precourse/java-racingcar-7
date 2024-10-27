package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.GameResult;
import racingcar.model.service.GameService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class GameServiceTest {

    @Test
    void 두게임을_진행하고_우승자를_반환하다() {
        int playCnt = 5;
        String carNames = "pobi,woni,jun";

        GameResult gameResult = GameService.play(playCnt, carNames);

        // 랜덤값으로 인해 우승자를 정확히 예측할 수 없음
        assertThat(gameResult).isNotNull();
    }
}

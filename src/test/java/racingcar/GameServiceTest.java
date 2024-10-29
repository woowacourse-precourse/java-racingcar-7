package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.domain.GameResult;
import racingcar.model.service.GameService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GameServiceTest {

    @Test
    void 게임실행결과_검증테스트() {

        String carNames = "pobi,woni,jun";
        int playCnt = 5;

        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();

        GameService gameService = new GameService(List.of(carNames.split(",")), playCnt, numberGenerator);

        GameResult gameResult = gameService.playGame();

        assertNotNull(gameResult);
        assertTrue(gameResult.getRoundResults().size() > 0);
    }
}

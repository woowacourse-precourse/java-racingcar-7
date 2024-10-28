package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.NumberGenerator;
import racingcar.model.domain.GameResult;
import racingcar.model.service.GameService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class GameServiceTest {

    @Test
    void 게임진행_후_우승자_반환() {
        int playCnt = 4;
        String carNames = "pobi,woni,jun";
        NumberGenerator numberGenerator = new NumberGeneratorTest(List.of(3, 4, 2, 1, 5));

        GameService gameService = new GameService(Arrays.asList(carNames.split(",")), playCnt, numberGenerator);
        GameResult gameResult = gameService.playGame();

        assertThat(gameResult).isNotNull();
    }
}

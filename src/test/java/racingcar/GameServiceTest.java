package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    GameService gameService = new GameService();

    @Test
    void 우승자_출력_테스트() {

        //given
        Map<String, Integer> resultOfRacingGame = new HashMap<>();
        resultOfRacingGame.put("wozi", 6);
        resultOfRacingGame.put("woni", 4);
        resultOfRacingGame.put("jepp", 5);

        //when
        String winner = gameService.findingWinner(resultOfRacingGame);

        //then
        assertThat(winner).isEqualTo("wozi");

    }

    @Test
    void 중복_우승자_출력_테스트() {

        //given
        Map<String, Integer> resultOfRacingGame = new HashMap<>();
        resultOfRacingGame.put("pobi", 5);
        resultOfRacingGame.put("woni", 5);

        //when
        String winner = gameService.findingWinner(resultOfRacingGame);

        //then
        assertThat(winner).isEqualTo("pobi,woni");

    }


}

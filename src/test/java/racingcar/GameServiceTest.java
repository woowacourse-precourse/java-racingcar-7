package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void 이름_공백_예외처리() {

        //given
        String invalidInput = "";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.setCarsNames(invalidInput);
        });
    }

    @Test
    void 전진횟수_공백_입력_예외처리() {
        //given
        String invalidInput = "";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.setNumberOfRounds(invalidInput);
        });
    }

    @Test
    void 이름_null_예외처리() {

        //given
        String invalidInput = null;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.setCarsNames(invalidInput);
        });
    }

    @Test
    void 전진횟수_null_예외처리() {
        //given
        String invalidInput = null;

        //when&then
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.setNumberOfRounds(invalidInput);
        });
    }

    @Test
    void 이름_5글자_이상_예외처리() {
        //given
        String invalidInput = "tokki,tokiiiiii";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.setCarsNames(invalidInput);
        });
    }

}

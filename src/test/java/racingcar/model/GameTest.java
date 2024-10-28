package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    void Game_생성_테스트() {
        // given
        List<String> testCarNames = List.of("sieun", "pobi", "jun");
        int round = 5;

        // when
        Game testGame = Game.start(testCarNames, round);
        Game expectedGame = Game.start(testCarNames, round);

        // then
        assertEquals(testGame, expectedGame);
    }

    @Test
    void Game_예외_중복_이름_테스트() {
        // given
        List<String> carNames = List.of("sieun", "sieun");
        int round = 5;

        // when & then
        assertThatThrownBy(() -> Game.start(carNames, round))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

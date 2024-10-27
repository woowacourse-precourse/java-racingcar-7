package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;
    private List<RacingCar> players;
    private static final String TOTAL_ROUND = "6";

    @BeforeEach
    void setUp() {
        players = List.of(new RacingCar("pobi"), new RacingCar("woni"), new RacingCar("jun"));
        game = new Game(players, TOTAL_ROUND);
    }

    @Test
    void Game_객체_초기화_테스트() {
        assertEquals(Integer.parseInt(TOTAL_ROUND), game.getTotalRound());
        assertEquals(1, game.getCurrentRound());
        assertEquals(3, game.getPlayers().size());
    }

    @Test
    void 라운드_종료시_게임_진행_불가능() {
        for (int i = 0; i < game.getTotalRound(); i++) {
            game.play();
        }
        assertFalse(game.isNotFinished());
    }

    @Test
    void 라운드가_미종료시_게임_진행_가능() {
        game.play();
        assertTrue(game.isNotFinished());
    }
}
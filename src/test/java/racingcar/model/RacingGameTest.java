package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private RacingGame racingGame;
    private List<RacingCar> players;
    private static final String TOTAL_ROUND = "6";

    @BeforeEach
    void setUp() {
        players = List.of(new RacingCar("pobi"), new RacingCar("woni"), new RacingCar("jun"));
        racingGame = new RacingGame(players, TOTAL_ROUND);
    }

    @Test
    void Game_객체_초기화_테스트() {
        assertEquals(Integer.parseInt(TOTAL_ROUND), racingGame.getTotalRound());
        assertEquals(1, racingGame.getCurrentRound());
        assertEquals(3, racingGame.getPlayers().size());
    }

    @Test
    void 라운드_종료시_게임_진행_불가능() {
        for (int i = 0; i < racingGame.getTotalRound(); i++) {
            racingGame.play();
            racingGame.incrementRound();
        }
        assertFalse(racingGame.isNotFinished());
    }

    @Test
    void 라운드가_미종료시_게임_진행_가능() {
        racingGame.play();
        assertTrue(racingGame.isNotFinished());
    }

    @Test
    void 최종_우승자_한_명_테스트() {
        players.getFirst().move();
        players.getFirst().move();
        players.getFirst().move();

        List<RacingCar> finalWinners = racingGame.findFinalWinners();

        assertEquals(finalWinners.size(), 1);
        assertEquals(finalWinners.getFirst(), players.getFirst());
    }

    @Test
    void 최종_우승자_두_명_테스트() {
        players.getFirst().move();
        players.getFirst().move();

        players.getLast().move();
        players.getLast().move();

        List<RacingCar> finalWinners = racingGame.findFinalWinners();

        assertEquals(finalWinners.size(), 2);
        assertEquals(finalWinners.getFirst(), players.getFirst());
        assertEquals(finalWinners.getLast(), players.getLast());
    }
}
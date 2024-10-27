package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {
    private static final int GAMECOUNT = 10;
    GameService game;

    @BeforeEach
    public void setUp() {
        List<String> carNames = new ArrayList<>(List.of("pobi", "woni", "jun"));
        game = new GameService(GAMECOUNT, carNames);
    }

    @Test
    public void moveTest() {
        game.move("pobi", 3);
        game.move("woni", 4);
        Map<String, Integer> carMap =  game.getCars();

        assertEquals(0, carMap.get("pobi"));
        assertEquals(1, carMap.get("woni"));
    }

    @Test
    public void getWinnerTest() {
        game.move("pobi", 4);
        game.move("woni", 4);

        List<String> winners = game.getWinners();

        assertTrue(winners.containsAll(Arrays.asList("pobi", "woni")));
    }

    @Test
    public void runGameTest() {
        game.runGame();

        List<String> winners = game.getWinners();
        List<Map<String, Integer>> record = game.getRecord();

        assertFalse(winners.isEmpty());
        assertEquals(GAMECOUNT, record.size());

    }

}

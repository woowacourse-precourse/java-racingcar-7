package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private static final int GAMECOUNT = 10;
    Game game;

    @BeforeEach
    public void setUp() {
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 0);
        cars.put("woni", 0);
        cars.put("jun", 0);
        game = new Game(GAMECOUNT, cars);
    }

    @Test
    public void moveTest() {
        game.move("pobi", 3);
        game.move("woni", 4);
        Map<String, Integer> cars =  game.getCars();

        assertEquals(0, cars.get("pobi"));
        assertEquals(1, cars.get("woni"));
    }

    @Test
    public void generateRandomInRangeTest(){
        int randomNumber = game.generateRandomInRange(0, 9);

        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    public void getWinnerTest() {
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 3);
        cars.put("jun", 1);
        game = new Game(GAMECOUNT, cars);

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

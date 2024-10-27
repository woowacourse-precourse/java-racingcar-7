package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game;

    @BeforeEach
    public void setUp() {
        int gameCount = 10;
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 0);
        cars.put("woni", 0);
        cars.put("jun", 0);
        game = new Game(gameCount, cars);
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
        int gameCount = 10;
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 3);
        cars.put("jun", 1);
        game = new Game(gameCount, cars);
        List<String> winners = game.getWinners();

        assertTrue(winners.containsAll(Arrays.asList("pobi", "woni")));

    }

    @Test
    public void runGameTest() {

    }

}

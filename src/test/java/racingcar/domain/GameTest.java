package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game(10, null);

    @Test
    public void moveTest() {
        assertFalse(game.move(3));
        assertTrue(game.move(4));
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
        game = new Game(10, cars);

        List<String> winnerList = game.getWinner();
        assertTrue(winnerList.containsAll(Arrays.asList("pobi", "woni")));

    }

    @Test
    public void runGameTest() {

    }

}

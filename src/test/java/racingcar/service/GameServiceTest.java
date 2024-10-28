package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("자동차 전진 여부 테스트")
    public void moveTest() {
        game.move("pobi", 3);
        game.move("woni", 4);
        Map<String, Integer> carMap =  game.getCars();

        assertEquals(0, carMap.get("pobi"));
        assertEquals(1, carMap.get("woni"));
    }

    @Test
    @DisplayName("우승자 가져오기 테스트")
    public void getWinnerTest() {
        game.move("pobi", 4);
        game.move("woni", 4);

        List<String> winners = game.getWinners();

        assertTrue(winners.containsAll(Arrays.asList("pobi", "woni")));
    }

    @Test
    @DisplayName("게임 실행 결과 테스트")
    public void runGameTest() {
        game.runGame();

        List<String> winners = game.getWinners();
        List<Map<String, Integer>> record = game.getRecord();

        assertFalse(winners.isEmpty());
        assertEquals(GAMECOUNT, record.size());

    }

}

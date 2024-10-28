package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

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
    public void moveIfConditionMetTest() {
        Car pobi = game.getCarList().get(0);
        Car woni = game.getCarList().get(1);

        game.moveIfConditionMet(pobi, 3);
        game.moveIfConditionMet(woni, 4);

        assertEquals(0, pobi.getPosition());
        assertEquals(1, woni.getPosition());
    }

    @Test
    @DisplayName("우승자 가져오기 테스트")
    public void getWinnerTest() {
        Car pobi = game.getCarList().get(0);
        Car jun = game.getCarList().get(2);

        game.moveIfConditionMet(pobi, 4);
        game.moveIfConditionMet(jun, 4);

        List<String> winners = game.getWinners();

        assertTrue(winners.containsAll(Arrays.asList("pobi", "jun")));
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

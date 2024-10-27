package racingcar.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameResultDto;

class CalculatorTest {

    @Test
    void 랜덤_움직임_가능() {
        // given
        int randomNumber = 4; // boundNumber과 동일
        // when
        boolean result = Calculator.canMove(randomNumber);
        // then
        assertTrue(result);
    }

    @Test
    void 랜덤_움직임_불가() {
        // given
        int randomNumber = 3;
        // when
        boolean result = Calculator.canMove(randomNumber);
        // then
        assertFalse(result);
    }

    @Test
    void 단일_우승자() {
        // given
        Map<String, Integer> gameData = new HashMap<>();
        gameData.put("car1", 3);
        gameData.put("car2", 5); // 최대 위치
        gameData.put("car3", 2);
        GameResultDto gameResultDto = new GameResultDto(gameData);

        // when
        List<String> winners = Calculator.findWinners(gameResultDto);

        // then
        assertEquals(1, winners.size(), "우승자는 한 명이어야 합니다.");
        assertEquals("car2", winners.get(0), "car2가 우승자이어야 합니다.");
    }

    @Test
    void 다중_우승자() {
        // given
        Map<String, Integer> gameData = new HashMap<>();
        gameData.put("car1", 5); // 최대 위치
        gameData.put("car2", 5); // 최대 위치
        gameData.put("car3", 3);
        GameResultDto gameResultDto = new GameResultDto(gameData);

        // when
        List<String> winners = Calculator.findWinners(gameResultDto);

        // then
        assertEquals(2, winners.size(), "우승자는 두 명이어야 합니다.");
        assertTrue(winners.contains("car1"), "car1이 우승자이어야 합니다.");
        assertTrue(winners.contains("car2"), "car2가 우승자이어야 합니다.");
    }

    @Test
    void 모두_우승자() {
        // given
        Map<String, Integer> gameData = new HashMap<>();
        gameData.put("car1", 4);
        gameData.put("car2", 4);
        gameData.put("car3", 4);
        GameResultDto gameResultDto = new GameResultDto(gameData);

        // when
        List<String> winners = Calculator.findWinners(gameResultDto);

        // then
        assertEquals(3, winners.size(), "모든 자동차가 승자이어야 합니다.");
        assertTrue(winners.containsAll(Arrays.asList("car1", "car2", "car3")), "모든 자동차가 승자이어야 합니다.");
    }

    @Test
    void 게임_데이터_예외_검증() {
        // given
        Map<String, Integer> gameData = new HashMap<>();
        GameResultDto gameResultDto = new GameResultDto(gameData);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Calculator.findWinners(gameResultDto),
                "gameData가 비어있을 때 IllegalArgumentException이 발생해야 합니다.");
    }
}

package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private final RacingCar racingCar = new RacingCar();

    @Test
    public void 우승자_찾기_단일_우승자() {
        // Given
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 1);
        cars.put("jun", 2);

        // When
        List<String> winners = racingCar.findWinner(cars);

        // Then
        assertEquals(1, winners.size());
        assertTrue(winners.contains("pobi"));
    }

    @Test
    public void 우승자_찾기_다중_우승자() {
        // Given
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 3);
        cars.put("jun", 2);

        // When
        List<String> winners = racingCar.findWinner(cars);

        // Then
        assertEquals(2, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
    }

    @Test
    public void 우승자_찾기_모두_우승자() {
        // Given
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 3);
        cars.put("jun", 3);

        // When
        List<String> winners = racingCar.findWinner(cars);

        // Then
        assertEquals(3, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
        assertTrue(winners.contains("jun"));
    }
}
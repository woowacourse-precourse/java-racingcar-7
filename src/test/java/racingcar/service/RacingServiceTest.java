package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingServiceTest {

    private RacingService racingService;
    private HashMap<String, Integer> cars;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
        cars = new HashMap<>();

        cars.put("A", 0);
        cars.put("B", 4);
        cars.put("C", 3);
    }

    @Test
    @DisplayName("우승판별 메서드 테스트")
    void testRacingWinner() {
        List<String> resultWinner = new ArrayList<>();
        resultWinner.add("B");

        List<String> testWinner = racingService.racingWinner(cars);

        assertEquals(resultWinner, testWinner);
    }

    @Test
    @DisplayName("공동 우승시 우승판별 메서드 테스트")
    void testRacingWinners() {
        List<String> resultWinner = new ArrayList<>();
        cars.put("A", 4);
        resultWinner.add("A");
        resultWinner.add("B");

        List<String> testWinner = racingService.racingWinner(cars);

        assertEquals(resultWinner, testWinner);
    }
}

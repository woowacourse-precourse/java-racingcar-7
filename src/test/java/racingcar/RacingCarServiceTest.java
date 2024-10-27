package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarServiceTest {
    LinkedHashMap<String, Integer> carMap;
    RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        LinkedHashMap<String, Integer> tmpMap = new LinkedHashMap<>();
        tmpMap.put("a", 1);
        tmpMap.put("b", 0);
        tmpMap.put("c", 0);
        racingCarService = new RacingCarService(tmpMap, 3);
    }

    @Test
    void 우승자_테스트() {
        //given
        carMap = new LinkedHashMap<>();
        carMap.put("a", 1);
        carMap.put("b", 0);
        carMap.put("c", 0);
        //when
        String winner = racingCarService.winner(carMap);
        //then
        assertEquals("a", winner);
    }
}

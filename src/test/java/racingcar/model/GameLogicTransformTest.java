package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
class GameLogicTransformTest {

    @Test
    void Map_구성_테스트() {
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        GameLogicTransform gameLogicTransform = new GameLogicTransform(resultMap);
        gameLogicTransform.mapByCarName("a, b, c");
        assertEquals(3, resultMap.size());
    }
}
package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EngineTest {

    @Test
    @DisplayName("엔진 생성 테스트")
    void createEngine() {
        Long performanceRegulation = 1L;
        Long oilConsumption = 1L;
        Engine engine = new Engine(performanceRegulation, oilConsumption);

        assertEquals(performanceRegulation, engine.getPerformance());
        assertEquals(oilConsumption, engine.getOilConsumption());
    }
}
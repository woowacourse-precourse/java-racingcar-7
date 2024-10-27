package racingcar.service.prep;

import racingcar.domain.Engine;

public class EngineService {
    public Engine tunedEngine(Long performanceRegulation, Long oilConsumption) {
        return new Engine(performanceRegulation, oilConsumption);
    }
}

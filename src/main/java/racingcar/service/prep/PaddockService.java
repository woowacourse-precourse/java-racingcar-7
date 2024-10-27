package racingcar.service.prep;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Engine;
import racingcar.domain.Paddock;
import racingcar.domain.RacingCar;
import racingcar.domain.Registration;
import racingcar.service.constant.RacingRules;

public class PaddockService {

    private final EngineService engineService = new EngineService();

    public Paddock createPaddock(Registration gameInfo) {
        List<Car> openField = new ArrayList<>();
        Long oilProvision = gameInfo.getLapCount();

        for (String carName : gameInfo.getLineup()) {
            openField.add(calibrate(carName, oilProvision));
        }
        return new Paddock(openField);
    }

    private Car calibrate(String carName, Long oilProvision) {
        Engine tunedEngine = engineService.tunedEngine(
                RacingRules.BASIC_ENGINE_PERFORMANCE_REGULATION.status()
                ,RacingRules.BASIC_OIL_CONSUMPTION_REGULATION.status());

        return new RacingCar(carName, oilProvision, tunedEngine);
    }
}

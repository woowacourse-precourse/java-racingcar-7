package racingcar.service;

import racingcar.model.entity.Cars;
import racingcar.model.dto.RacingResult;
import racingcar.model.entity.RacingChance;

public interface RacingService {
    
    void raceOfCarsAndChance(Cars cars, RacingChance racingChance);

    RacingResult getResult();
}

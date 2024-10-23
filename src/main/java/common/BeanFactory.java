package common;

import input.ValidatedInputData;
import policy.RacingPolicy;
import repository.Repository;
import service.RacingService;

public interface BeanFactory {

    RacingService provideRacingService(ValidatedInputData validatedInputData);
    RacingPolicy provideRacingPolicy();

    Repository provideVehicleRepository();

}

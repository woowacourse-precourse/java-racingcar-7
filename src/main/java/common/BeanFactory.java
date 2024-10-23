package common;

import input.ValidatedInputData;
import policy.RacingPolicy;
import repository.VehicleRepository;
import service.RacingService;

public interface BeanFactory {

    RacingService provideRacingService(ValidatedInputData validatedInputData);
    RacingPolicy provideRacingPolicy();

    VehicleRepository provideVehicleRepository();

}

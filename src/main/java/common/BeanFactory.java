package common;

import policy.RacingPolicy;
import repository.VehicleRepository;
import service.RacingService;

public interface BeanFactory {

    RacingService provideRacingService();
    RacingPolicy provideRacingPolicy();

    VehicleRepository provideVehicleRepository();

}

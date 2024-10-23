package common;

import input.ValidatedInputData;
import java.util.HashMap;
import policy.RacingCarPolicy;
import policy.RacingPolicy;
import repository.CarRepository;
import repository.Repository;
import service.RacingCarService;
import service.RacingService;

public class RacingCarBeanFactory implements BeanFactory {

    @Override
    public RacingPolicy provideRacingPolicy() {
        return new RacingCarPolicy();
    }

    @Override
    public Repository provideVehicleRepository() {
        return new CarRepository(new HashMap<String, Long>());
    }

    @Override
    public RacingService provideRacingService(ValidatedInputData validatedInputData) {
        return new RacingCarService(validatedInputData,provideRacingPolicy(),provideVehicleRepository());
    }

}

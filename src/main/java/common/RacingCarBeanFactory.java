package common;

import input.ValidatedInputData;
import java.util.HashMap;
import policy.RacingCarPolicyImpl;
import policy.RacingPolicy;
import repository.CarRepositoryImpl;
import repository.Repository;
import service.RacingCarServiceImpl;
import service.RacingService;
import vehicle.Vehicle;

public class RacingCarBeanFactory implements BeanFactory {

    @Override
    public RacingPolicy provideRacingPolicy() {
        return new RacingCarPolicyImpl();
    }

    @Override
    public Repository provideVehicleRepository() {
        return new CarRepositoryImpl(new HashMap<String, Long>());
    }

    @Override
    public RacingService provideRacingService(ValidatedInputData validatedInputData) {
        return new RacingCarServiceImpl(validatedInputData,provideRacingPolicy(),provideVehicleRepository());
    }

}

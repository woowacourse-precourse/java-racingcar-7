package common;

import input.ValidatedInputData;
import java.util.HashMap;
import policy.RacingCarPolicyImpl;
import policy.RacingPolicy;
import repository.CarRepositoryImpl;
import repository.VehicleRepository;
import service.RacingCarServiceImpl;
import service.RacingService;
import vehicle.Car;

public class RacingCarBeanFactory implements BeanFactory {


    @Override
    public RacingPolicy provideRacingPolicy() {
        return new RacingCarPolicyImpl();
    }

    @Override
    public VehicleRepository provideVehicleRepository() {
        return new CarRepositoryImpl(new HashMap<String,Car>());
    }

    @Override
    public RacingService provideRacingService(ValidatedInputData validatedInputData) {
        return new RacingCarServiceImpl(validatedInputData,provideRacingPolicy(),provideVehicleRepository());
    }

}

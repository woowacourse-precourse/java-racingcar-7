package common;

import java.util.HashMap;
import java.util.Map;
import policy.CarRacingPolicyImpl;
import policy.RacingPolicy;
import repository.CarRepositoryImpl;
import repository.VehicleRepository;
import service.RacingCarServiceImpl;
import service.RacingService;
import vehicle.Car;

public class RacingCarBeanFactory implements BeanFactory {


    @Override
    public RacingService provideRacingService() {
        return new RacingCarServiceImpl();
    }

    @Override
    public RacingPolicy provideRacingPolicy() {
        return new CarRacingPolicyImpl();
    }

    @Override
    public VehicleRepository provideVehicleRepository() {
        return new CarRepositoryImpl(new HashMap<String,Car>());
    }

}

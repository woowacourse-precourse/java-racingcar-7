package common;

import dto.ValidatedInputDataDTO;
import java.util.HashMap;
import policy.RacingCarPolicy;
import repository.RacingCarRepository;
import service.RacingCarService;
import service.RacingService;
import vehicle.Vehicle;

public class RacingCarBeanFactory{

    public RacingCarRepository provideRacingStatusRepository() {
        return new RacingCarRepository(new HashMap<String, Vehicle>());
    }


    public RacingService provideRacingService(ValidatedInputDataDTO validatedInputDataDTO) {
        return new RacingCarService(validatedInputDataDTO,new RacingCarPolicy(), provideRacingStatusRepository());
    }

}

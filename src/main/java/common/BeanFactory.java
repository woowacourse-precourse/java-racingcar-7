package common;

import dto.ValidatedInputDataDTO;
import policy.RacingPolicy;
import repository.Repository;
import service.RacingService;

public interface BeanFactory {

    RacingService provideRacingService(ValidatedInputDataDTO validatedInputDataDTO);
    RacingPolicy provideRacingPolicy();

    Repository provideVehicleRepository();

}

package controller;

import common.RacingCarBeanFactory;
import dto.RacingOutputDTO;
import dto.ValidatedInputDataDTO;
import service.RacingService;

public class RacingController {

    private final RacingCarBeanFactory beanFactory;
    private final ValidatedInputDataDTO validatedInputDataDTO;

    public RacingController(RacingCarBeanFactory beanFactory, ValidatedInputDataDTO validatedInputDataDTO) {
        this.beanFactory = beanFactory;
        this.validatedInputDataDTO = validatedInputDataDTO;
    }

    public RacingOutputDTO run() {
        RacingService racingService = beanFactory.provideRacingService(validatedInputDataDTO);
        return racingService.racingStart();
    }


}

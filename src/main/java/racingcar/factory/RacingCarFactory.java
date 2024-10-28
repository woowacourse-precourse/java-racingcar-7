package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.model.RacingCarModel;
import racingcar.service.RacingCarService;
import racingcar.service.ResultGeneratorService;

public class RacingCarFactory {

    public static RacingCarController createController(){
        RacingCarModel racingCarModel = new RacingCarModel();
        ResultGeneratorService resultGeneratorService = new ResultGeneratorService();
        RacingCarService racingCarService = new RacingCarService(racingCarModel, resultGeneratorService);
        return new RacingCarController(racingCarService);
    }
}

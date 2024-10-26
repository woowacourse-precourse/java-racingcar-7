package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.model.RacingCarModel;
import racingcar.service.RacingCarService;

public class RacingCarFactory {

    public static RacingCarController createController(){
        RacingCarModel model = new RacingCarModel();
        RacingCarService service = new RacingCarService(model);
        return new RacingCarController(service);
    }
}

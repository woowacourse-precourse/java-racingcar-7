package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.service.AwardService;
import racingcar.service.GameService;
import racingcar.util.DependencyFactory;
import racingcar.util.Validation;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {

        DependencyFactory.initialize();

        final Validation validation = new Validation();
        final Input input = new Input(validation);
        final Output output = new Output();
        final GameService gameService = new GameService(output);
        final AwardService awardService = new AwardService(output);

        final CarRacingController carRacingController = new CarRacingController(input, output, gameService, awardService);

        carRacingController.startCarRacing();

    }
}

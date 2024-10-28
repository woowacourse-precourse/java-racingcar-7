package racingcar.config;

import racingcar.View.InputValidator;
import racingcar.service.CarRacing;
import racingcar.controller.CarRacingController;
import racingcar.service.Racers;
import racingcar.service.RacingRule;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.service.CarRacingService;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public CarRacingController carRacingController() {
        return new CarRacingController(inputView(), inputValidator(), outputView());
    }

    public CarRacingService carRacingService() {
        return new CarRacingService();
    }

    public RacingRule racingRule() {
        return carRacingService().setRacingRule();
    }

    public Racers racers() {
        return carRacingService().registerRacers(carRacingController().extractCarNames());
    }

    public int totalRounds() {
        return carRacingService().registerTotalRounds(carRacingController().convertToNumber());
    }

    public CarRacing carRacing() {
        return new CarRacing(racingRule(), racers());
    }

    public void run() {
        CarRacingController carRacingController = carRacingController();
        CarRacing carRacing = carRacing();
        carRacingController.deliverRaceProgress(carRacing, totalRounds());
        carRacingController.deliverWinners(carRacing);
    }
}
package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.service.CarRaceService;
import racingcar.service.RaceResultService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarRaceService carRaceService = new CarRaceService();
        RaceResultService raceResultService = new RaceResultService();
        CarRaceController carRaceController = new CarRaceController(carRaceService, inputView, outputView, raceResultService);

        carRaceController.startRace();
    }
}

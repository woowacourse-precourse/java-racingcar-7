package racingcar.racingcar;

import java.util.List;
import racingcar.constant.Strings;
import racingcar.record.RecordController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private static final RacingCarController RACING_CAR_CONTROLLER = new RacingCarController();
    private final RecordController recordController = RecordController.getInstance();
    private final RacingCarService racingCarService = RacingCarService.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    private RacingCarController() {

    }

    public static RacingCarController getInstance() {
        return RACING_CAR_CONTROLLER;
    }

    public void run() {
        String joinedCarNames = inputView.requestString(outputView, Strings.REQUEST_RACING_CAR_NAME.getMessage());
        List<String> carNames = racingCarService.splitCarName(joinedCarNames);
        List<RacingCar> racingCars = racingCarService.makeCar(carNames);
        recordController.setRacingCarList(racingCars);
    }
}

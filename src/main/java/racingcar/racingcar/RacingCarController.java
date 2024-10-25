package racingcar.racingcar;

import static racingcar.constant.Strings.*;

import java.util.List;
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
        String joinedCarNames = getCarNames();
        List<RacingCar> racingCars = racingCarService.makeRacingCarList(joinedCarNames);
        recordController.setRacingCarList(racingCars);
    }

    private String getCarNames() {
        return inputView.requestString(outputView, REQUEST_RACING_CAR_NAME.getMessage());
    }
}

package racingcar.racingcar;

import java.util.List;
import racingcar.record.RecordController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private static final RacingCarController RACING_CAR_CONTROLLER = new RacingCarController();
    private static final String REQUEST_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final RecordController recordController = RecordController.getInstance();
    private final RacingCarService racingCarService = RacingCarService.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    private RacingCarController() {

    }
    public static RacingCarController getInstance() {
        return RACING_CAR_CONTROLLER;
    }

    public void run(){
        String joinedCarNames = inputView.inputString(REQUEST_RACING_CAR_NAME);
        List<String> carNames = racingCarService.splitCarName(joinedCarNames);
        List<RacingCar> racingCars = racingCarService.makeCar(carNames);
        recordController.setRacingCarList(racingCars);
    }
}

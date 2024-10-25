package racingcar.racingcar;

import static racingcar.constant.Strings.REQUEST_RACING_CAR_NAME;

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

    /**
     * ,로 나눠진 이름 문자열을 받아서 레이싱 카 리스트로 변환받고 record로 넘긴다.
     */
    public void run() {
        String joinedCarNames = requestCarNames();
        List<RacingCar> racingCars = racingCarService.makeRacingCarList(joinedCarNames);
        recordController.setRacingCarList(racingCars);
    }

    private String requestCarNames() {
        return inputView.requestString(outputView, REQUEST_RACING_CAR_NAME.getMessage());
    }
}

package racingcar.record;

import java.util.List;
import racingcar.constant.Strings;
import racingcar.racingcar.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RecordController {
    private static final RecordController RECORD_CONTROLLER = new RecordController();
    private final RecordService recordService = RecordService.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private List<RacingCar> racingCarList;

    private RecordController() {

    }

    public void setRacingCarList(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public static RecordController getInstance() {
        return RECORD_CONTROLLER;
    }

    public void run() {
        String tryTimes = inputView.requestString(Strings.REQUEST_TRY_TIMES.getMessage());
        int intTryTimes = recordService.raceSetting(tryTimes);
        String result = recordService.raceStart(racingCarList, intTryTimes);
        outputView.printString(result);
    }
}

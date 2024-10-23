package racingcar.record;

import java.util.List;
import racingcar.racingcar.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RecordController {
    private static final RecordController RECORD_CONTROLLER = new RecordController();
    private static final String REQUEST_TRY_TIMES = "시도할 횟수는 몇 회인가요?";

    private final RecordService recordService = RecordService.getInstance();

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private List<RacingCar> racingCarList;
    private RecordController(){

    }
    public void setRacingCarList(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public static RecordController getInstance() {
        return RECORD_CONTROLLER;
    }

    public void run(){
        String tryTimes = inputView.inputString(REQUEST_TRY_TIMES);
        int intTryTimes = recordService.raceSetting(tryTimes);
        String result = recordService.raceStart(racingCarList, intTryTimes);
        outputView.outputString(result);
    }
}

package racingcar.record;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RecordController {
    private static final RecordController RECORD_CONTROLLER = new RecordController();
    private final RecordService recordService = RecordService.getInstance();
    private static final String REQUEST_TRY_TIMES = "시도할 횟수는 몇 회인가요?";
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private RecordController(){

    }

    public static RecordController getInstance() {
        return RECORD_CONTROLLER;
    }

    public void run(){
        String tryTimes = inputView.inputString(REQUEST_TRY_TIMES);
        recordService.raceStart(tryTimes);
    }
}

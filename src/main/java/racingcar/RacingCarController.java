package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    OutputView outputView;
    InputView inputView;

    public RacingCarController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run(){
        outputView.startMessagePrint();
        String readCarString = inputView.readCarString();
        outputView.tryCountMessage();
        String readTryCount = inputView.readTryCount();
        RacingCarCollection collection = new RacingCarCollection(readCarString, readTryCount);
        RacingCarService service = new RacingCarService(collection.getCarList(), collection.getTryCount());
        outputView.resultPrint(service.winner());
    }
}

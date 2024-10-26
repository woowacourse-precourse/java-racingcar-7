package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    OutputView outputView;
    InputView inputView;
    RacingCarCollection collection;
    RacingCarService service;

    public RacingCarController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run(){
        outputView.startMessagePrint();
        try{
            String readCarString = inputView.readCarString();
            outputView.tryCountMessage();
            String readTryCount = inputView.readTryCount();
            collection = new RacingCarCollection(readCarString, readTryCount);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        service = new RacingCarService(collection.getCarList(), collection.getTryCount());
        outputView.resultPrint(service.winner());
    }
}

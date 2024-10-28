package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.ViewService;
import racingcar.util.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewController {
    private static ViewController viewController;
    private static ViewService viewService = ViewService.getInstance();
    private static InputView inputView=InputView.getInstance();
    private static OutputView outputView=OutputView.getInstance();

    public static ViewController getInstance() {
        if (viewController == null){
            viewController = new ViewController();
        }
        return viewController;
    }

    public String[] printGuide(){
        outputView.inputMessage();
        String carName = inputView.readLine();
        return(viewService.inputValidation(carName));
    }

    public void printCountGuide(){
        outputView.inputCountMessage();
        String count = inputView.readLine();
        int countNum = viewService.countValidation(count);
        Utils.setAdvaceCount(countNum);
    }

    public void printAdvance(List<Car> cars){
        outputView.printAdvance(cars);
    }

    public void printWinner(List<String> winnnerNames){
        outputView.printWinner(winnnerNames);
    }
}

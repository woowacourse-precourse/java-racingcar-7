package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private static final String NEW_LINE = "\n";
    private static final String RESULT_ALERT = "실행 결과";

    private InputView inputView;
    private OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runGame(){
        Cars cars = setCars(inputView.enterCarNames());
        int count = inputView.enterCount();

        doRacing(cars, count);

        List<String> winner = cars.getWinner();
        outputView.printWinner(winner);
    }

    public Cars setCars(List<String> carList){
        return new Cars(carList);
    }

    public void doRacing(Cars cars, int count){
        System.out.print(NEW_LINE);
        System.out.println(RESULT_ALERT);

        while(count > 0){
            cars.moveCars();
            outputView.printResult(cars);
            count--;
        }

    }


}

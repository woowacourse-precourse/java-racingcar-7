package racingcar.controller;

import java.util.List;
import racingcar.message.Message;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private InputView inputView;
    private OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runGame(){
        Cars cars = Cars.setCars(inputView.enterCarNames());
        int count = inputView.enterCount();

        doRacing(cars, count);

        List<String> winner = cars.getWinner();
        outputView.printWinner(winner);
    }


    public void doRacing(Cars cars, int count){
        System.out.print(Message.newLine.getMessage());
        System.out.println(Message.result.getMessage());

        while(count > 0){
            cars.moveCars();
            outputView.printResult(cars);
            count--;
        }

    }


}

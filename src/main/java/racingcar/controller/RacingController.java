package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void runGame(){
        Cars cars = setCars(inputView.inputCarNames());
        int count = inputView.inputCount();

        runRacing(cars, count);

        List<String> winnerList= cars.getWinner();
        outputView.printWinner(winnerList);
    }

    public Cars setCars(List<String> carList){
        return new Cars(carList);
    }

    public void runRacing(Cars cars, int count){
        System.out.println();
        System.out.println("실행 결과");
        while(count > 0){
            cars.moveCars();
            outputView.printResult(cars);
            count--;
        }
    }


}

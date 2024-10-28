package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarListParser;
import racingcar.model.WinnerSelector;
import racingcar.view.inputView.CarNameInputView;
import racingcar.view.inputView.InputView;
import racingcar.view.inputView.MoveCountInputView;
import racingcar.view.outputView.WinnersOutputView;

import java.util.List;

public class RacingController {
    public void startRacing(){
        InputView carNameInputView = new CarNameInputView();
        InputView moveCountInputView = new MoveCountInputView();
        String carListInput = carNameInputView.input();
        Integer moveCountInput = Integer.parseInt(moveCountInputView.input());

        CarListParser parser = new CarListParser(carListInput);
        List<Car> carList = parser.parsingData();

        WinnerSelector winnerSelector = new WinnerSelector(carList, moveCountInput);
        winnerSelector.racing();
        winnerSelector.selectWinners();

        WinnersOutputView winnersOutputView = new WinnersOutputView(winnerSelector);
        winnersOutputView.print();
    }
}

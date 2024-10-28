package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarListParser;
import racingcar.model.WinnerSelector;
import racingcar.view.inputView.CarNameInputView;
import racingcar.view.inputView.InputView;
import racingcar.view.inputView.MoveCountInputView;
import racingcar.view.outputView.OutputView;
import racingcar.view.outputView.ProgressOutputView;
import racingcar.view.outputView.WinnersOutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private List<Car> carList;
    private final InputView carNameInputView;
    private final InputView moveCountInputView;

    public RacingController(){
        this.carNameInputView = new CarNameInputView();
        this.moveCountInputView = new MoveCountInputView();
    }

    public void startRacing(){
        String carListInput = carNameInputView.input();
        Integer moveCountInput = Integer.parseInt(moveCountInputView.input());

        CarListParser parser = new CarListParser(carListInput);
        carList = parser.parsingData();
    }
}

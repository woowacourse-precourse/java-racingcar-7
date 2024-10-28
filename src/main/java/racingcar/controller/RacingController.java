package racingcar.controller;

import racingcar.model.Car;
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
    private final List<Car> carList;
    private final WinnerSelector winnerSelector;
    private final InputView carNameInputView;
    private final InputView moveCountInputView;
    private final OutputView progressOutputView;
    private final OutputView winnersOutputView;

    public RacingController(){
        this.carList = new ArrayList<>();
        this.winnerSelector = new WinnerSelector();
        this.carNameInputView = new CarNameInputView();
        this.moveCountInputView = new MoveCountInputView();
        this.progressOutputView = new ProgressOutputView(carList);
        this.winnersOutputView = new WinnersOutputView(winnerSelector);
    }

    public void startRacing(){
        carNameInputView.input();
        moveCountInputView.input();
    }
}

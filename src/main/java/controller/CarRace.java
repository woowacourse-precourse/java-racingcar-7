package controller;

import view.InputView;
import view.OutputView;

public class CarRace {

    public static void start() {
        OutputView.printInputCarNames();
        InputView.getCarNames();
        OutputView.printInputTryCount();
        InputView.getTryCount();
    }
}

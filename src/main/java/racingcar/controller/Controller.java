package racingcar.controller;


import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public void start() {
        outputView.askCarName();
        String userInput = inputView.getCarNames();

        ArrayList<String> carNames = extractCarName(userInput);
        inputView.validateCarNames(carNames);

        outputView.askTurn();
        int numberOfTurn = inputView.getNumberOfTurn();



    }

    public ArrayList<String> extractCarName(String input) {
        String[] items = input.split(",", -1);
        return new ArrayList<>(List.of(items));
    }




}

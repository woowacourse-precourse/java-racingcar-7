package racingcar.controller;


import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    InputView inputView = new InputView();

    public void start() {

        String userInput = inputView.getCarNames();

        ArrayList<String> carNames = extractCarName(userInput);

        int numberOfTurn = inputView.getNumberOfTurn();


    }

    public ArrayList<String> extractCarName(String input) {
        String[] items = input.split(",", -1);
        return new ArrayList<>(List.of(items));
    }




}

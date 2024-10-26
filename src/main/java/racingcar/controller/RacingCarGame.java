package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    private InputView inputView;
    private OutputView outputView;
    private List<String> carName;
    private List<Car> carList;
    private String inputString;

    public RacingCarGame(InputView inputView, OutputView outputView) { //의존성 주입 다시 공부하기
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRacingGame() {
        outputView.printStartMessage();
        inputString = inputView.getInput();
        carName = Arrays.asList(inputString.split(","));
        for (String name : carName) {
            carList.add(new Car(name));
        }
    }

    private void playOneRound() {

    }

}

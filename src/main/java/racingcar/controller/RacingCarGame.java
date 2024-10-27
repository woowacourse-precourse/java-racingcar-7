package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Number;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Number number;
    private final List<Car> carList;

    public RacingCarGame(InputView inputView, OutputView outputView, Number number) { //의존성 주입 다시 공부하기
        this.inputView = inputView;
        this.outputView = outputView;
        this.number = number;
        this.carList = new ArrayList<>();
    }

    public void startRacingGame() {
        outputView.printStartMessage();
        String inputString = inputView.getInput();
        outputView.printTryCountMessage();
        int tryCount = Integer.parseInt(inputView.getInput());

        List<String> carName = Arrays.asList(inputString.split(","));
        for (String name : carName) {
            carList.add(new Car(name));
        }

        outputView.printResultMessage();
        while (tryCount > 0) {
            playOneRound();
            tryCount--;
        }
        
        outputView.printWinner();
    }

    private void playOneRound() {
        for (Car car : carList) {
            car.setDistance(number.getRandomNumber());
        }

        for (Car car : carList) {
            outputView.printCarDistance(car.getName(), car.getDistance());
        }
        System.out.println();
    }
}

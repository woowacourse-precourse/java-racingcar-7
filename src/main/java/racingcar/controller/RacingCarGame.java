package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Number;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Number number;
    private final Cars cars;
    private String inputString;

    public RacingCarGame(InputView inputView, OutputView outputView, Number number, Cars cars) { //의존성 주입 다시 공부하기
        this.inputView = inputView;
        this.outputView = outputView;
        this.number = number;
        this.cars = cars;
        this.inputString = "";
    }

    public void startRacingGame() {
        outputView.printStartMessage();
        this.inputString = inputView.getInput();
        outputView.printTryCountMessage();
        int tryCount = Integer.parseInt(inputView.getInput());

        cars.setCarList(inputString);

        outputView.printResultMessage();
        while (tryCount > 0) {
            playOneRound();
            tryCount--;
        }

        List<Car> winnerList = cars.getWinnerList();
        List<String> winnerNameList = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        outputView.printWinner(winnerNameList); //car을 넘겨주지 않고 car의 이름을 넘겨주는게 맞는지
    }

    private void playOneRound() {
        for (Car car : cars.getCarList()) {
            car.setDistance(number.getRandomNumber());
            outputView.printCarDistance(car.getName(), car.getDistance());
        }
        outputView.printEmptyLine();
    }
}

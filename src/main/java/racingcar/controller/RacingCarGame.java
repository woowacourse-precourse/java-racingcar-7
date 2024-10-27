package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Number;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Number number;
    private final Cars cars;
    private String inputString;
    private final List<Car> carList; // 자동차 리스트를 컨트롤러에서 갖나?

    public RacingCarGame(InputView inputView, OutputView outputView, Number number, Cars cars) { //의존성 주입 다시 공부하기
        this.inputView = inputView;
        this.outputView = outputView;
        this.number = number;
        this.cars = cars;
        this.inputString = "";
        this.carList = new ArrayList<>();
    }

    public void startRacingGame() {
        outputView.printStartMessage();
        this.inputString = inputView.getInput();
        outputView.printTryCountMessage();
        int tryCount = Integer.parseInt(inputView.getInput());

        setCarList();

        outputView.printResultMessage();
        while (tryCount > 0) {
            playOneRound();
            tryCount--;
        }

        List<Car> winnerList = cars.getWinnerList(carList);
        List<String> winnerNameList = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        outputView.printWinner(winnerNameList); //car을 넘겨주지 않고 car의 이름을 넘겨주는게 맞는지
    }

    private void setCarList() {
        List<String> carName = Arrays.asList(inputString.split(","));
        for (String name : carName) {
            carList.add(new Car(name));
        }
    }

    private void playOneRound() {
        for (Car car : carList) {
            car.setDistance(number.getRandomNumber());
            outputView.printCarDistance(car.getName(), car.getDistance());
        }
        outputView.printEmptyLine();
    }
}

package racingcar.controller;

import racingcar.handler.InputHandler;
import racingcar.handler.PrintHandler;
import racingcar.model.Car.Cars;
import racingcar.model.Referee;

public class Controller {
    private final PrintHandler printHandler;
    private final InputHandler inputHandler;

    public Controller() {
        this.printHandler = new PrintHandler();
        this.inputHandler = new InputHandler();

    }

    public void run() {
        printHandler.racingStartMessage();
        String[] tempCarNames = inputHandler.inputCarNames();
        printHandler.racingNumberMessage();
        Cars cars = new Cars(tempCarNames);
        int gameNumber = inputHandler.inputGameNumber();
        int maxCarListSize = cars.getCarListSize();
        Referee referee = new Referee(cars, maxCarListSize, gameNumber);
        // 앞으로 구현해야 하는 거
        // 자동차가 랜덤 숫자가 4 이상 일 때, 앞으로 간다.
        // 그걸 어떤 방식으로 해야 자동차 이름 별 position 값을 올릴 수 있을까?
        // position 어디에 위치해야 하는 것일까?
    }
}
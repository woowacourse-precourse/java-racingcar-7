package racingcar.controller;

import racingcar.model.CarNameValidator;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameValidator carNameValidator;
    private Cars cars;
    private int tryCount;

    public GameController(InputView inputView, CarNameValidator carNameValidator, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameValidator = carNameValidator;
    }

    public void run(){
        init();
        play();
        showWinners();
    }

    public void init(){
        String input = inputView.inputCarNames();
        String[] carNames = input.split(",");
        carNameValidator.validate(carNames);
        cars = new Cars(carNames);
        tryCount = inputView.inputTryCount();
    }

    public void play(){
        outputView.printPlayMessage();
        cars.playRound(tryCount);
        outputView.printPlayResults(cars.getResults());
    }

    public void showWinners(){
        List<String> winners = cars.getWinners();
        outputView.printWinners(winners);
    }
}

package racingcar.controller;

import racingcar.model.CarNameValidator;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameValidator carNameValidator;
    private Cars cars;
    private int tryCount;

    public GameController(CarNameValidator carNameValidator, OutputView outputView){
        this.outputView = new OutputView();
        this.carNameValidator = new CarNameValidator();
        this.inputView = new InputView();
    }

    public void init(){
        String input = inputView.inputCarNames();
        String[] carNames = input.split(",");
        carNameValidator.validate(carNames);
        cars = new Cars(carNames);
        tryCount = inputView.inputTryCount();
    }

    public void play(){
        cars.playRound(tryCount);

    }
}

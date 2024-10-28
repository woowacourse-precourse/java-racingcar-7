package racingcar;

import racingcar.controller.GameController;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	String carNamesInput = InputView.readCarNames();
    	String[] carNames = carNamesInput.split(",");
    	InputValidator.validateCarNames(carNames);
    	
    	String trialNumInput = InputView.readTrialNum();
    	InputValidator.validateTrilaNum(trialNumInput);
    	int trialNum = Integer.parseInt(trialNumInput);
    	
    	GameController game = new GameController(carNames, trialNum);
        game.play();
        ResultView.printWinners(game.getCars());
    	
    }
}

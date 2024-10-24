package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.SplitService;
import racingcar.valid.NumberValid;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private static GameController instance;
    private SplitService splitService = SplitService.getInstance();
    private Game game;

    private GameController() {
    }

    public static GameController getInstance() {
        if(instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void gameInput(){
        OutputView.requestCarNames();
        String names = InputView.inputCarsNames();
        List<String> splitNames = splitService.splitNames(names);
        OutputView.requestAttemptCount();
        String times = InputView.inputGameTimes();
        NumberValid.checkNumberType(times);
        NumberValid.checkNumber(Integer.parseInt(times));

        game = new Game(Integer.parseInt(times));
        for(String name: splitNames){
            game.addCar(name);
        }
    }

    public void gameProgress(){
        OutputView.printExecutionResult();
        for(int i = 0 ; i< game.getTryTimes(); i++){
            game.moveCars();
            OutputView.printCurrentStatus(game.getCars());
        }
    }

    public void gameResult(){
        OutputView.printWinners(game.getWinners());
    }
}

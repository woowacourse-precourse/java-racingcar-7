package racingcar.controller;

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
    public void startGame(){
        String names = promptName();
        String count = promptCount();
        validGameCount(count);
        setGame(splitService.splitNames(names), count);
        gameProgress();
        gameResult();
    }

    public String promptName(){
        OutputView.requestCarNames();
        return InputView.inputCarsNames();
    }

    public String promptCount(){
        OutputView.requestAttemptCount();
        return InputView.inputGameTimes();
    }

    public void validGameCount(String times){
        NumberValid.checkNumberType(times);
        NumberValid.checkNumber(Integer.parseInt(times));
    }

    public void setGame(List<String> names, String times){
        game = new Game(Integer.parseInt(times));
        for(String name: names){
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

package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static GameController instance;
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
        OutputView.requestAttemptCount();
        String times = InputView.inputGameTimes();

        //valid check
        game = new Game(Integer.parseInt(times));
        for(String name: names.split(",")){
            game.addCar(new Car(name));
        }
        System.out.println();
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

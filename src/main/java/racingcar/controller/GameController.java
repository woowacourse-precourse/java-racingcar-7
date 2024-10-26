package racingcar.controller;

import java.util.HashMap;
import racingcar.model.Game;
import racingcar.model.Winner;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private Input input = new Input();
    private Output output = new Output();
    private Winner winner = new Winner();
    private Game game = new Game();
    private HashMap<String, Integer> raceStatus;
    private int attemptedNumber;

    public void start() {

    }
}

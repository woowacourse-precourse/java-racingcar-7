package racingcar.controller;

import java.util.List;
import racingcar.model.CarFactory;
import racingcar.model.Race;
import racingcar.model.Winner;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private Input input = new Input();
    private CarFactory carFactory = new CarFactory();
    private List<String> carNames;
    private int tryNum;
    private Race race = new Race();
    private Output output = new Output();
    private Winner winner = new Winner();

    public void run() {

    }
}

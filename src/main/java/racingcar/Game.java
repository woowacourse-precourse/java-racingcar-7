package racingcar;

import java.util.List;

public class Game {

    public Game() {
        OutputHandler.printInstructionForCarNames();
        List<String> carNames = InputHandler.getCarNames();

        OutputHandler.printInstructionForTimes();
        int times = InputHandler.getTimes();
    }
}

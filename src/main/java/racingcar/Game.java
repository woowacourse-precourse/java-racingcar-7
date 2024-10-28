package racingcar;

public class Game {

    public Game() {
        OutputHandler.printInstructionForCarNames();
        String[] carNames = InputHandler.getCarNames();

        OutputHandler.printInstructionForTimes();
        int times = InputHandler.getTimes();
    }
}

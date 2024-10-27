package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;
import racingcar.input.ConsoleInputManager;
import racingcar.input.InputManager;
import racingcar.output.ConsoleOutputManager;
import racingcar.output.OutputManager;

public class Application {

    public static void main(String[] args) {
        InputManager inputManager = new ConsoleInputManager();
        OutputManager outputManager = new ConsoleOutputManager();
        RacingController controller = new RacingController(inputManager, outputManager);

        try {
            controller.setupGame();
            controller.startRace();
            controller.displayWinners();
        } catch (Exception e) {
            outputManager.displayError(e.getMessage());
            throw e;
        } finally {
            Console.close();
        }
    }
}

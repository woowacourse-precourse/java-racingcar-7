package racingcar;

import racingcar.inputManager.ConsoleInputManager;
import racingcar.inputManager.InputManager;
import racingcar.outputManager.ConsoleOutputManager;
import racingcar.outputManager.OutputManager;
import racingcar.race.Race;
import racingcar.referee.CarRacingReferee;
import racingcar.referee.Referee;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new ConsoleInputManager();
        OutputManager outputManager = new ConsoleOutputManager();
        Referee referee = new CarRacingReferee();

        Race race = new Race(inputManager, outputManager, referee);
        race.start();
    }
}

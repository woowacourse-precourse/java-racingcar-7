package racingcar;

import racingcar.controller.RaceController;
import racingcar.stream.ConsoleInput;
import racingcar.stream.ConsoleOutput;
import racingcar.stream.Input;
import racingcar.stream.Output;

public class Application {
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();

        RaceController raceController = new RaceController(output, input);
        raceController.doRace();
    }
}

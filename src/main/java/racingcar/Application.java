package racingcar;

import racingcar.domain.Car.Cars;
import racingcar.domain.Racing;
import racingcar.domain.Round;
import racingcar.io.Input.ConsoleInputHandler;
import racingcar.io.Input.InputHandler;
import racingcar.io.Output.ConsoleOutputHandler;
import racingcar.io.Output.OutputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        Cars cars = new Cars();
        Round round = new Round();
        Racing racing = new Racing(inputHandler, outputHandler, cars, round);

        racing.start();
    }
}

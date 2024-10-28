package racingcar;

import racingcar.domain.Car.Cars;
import racingcar.domain.Racing;
import racingcar.domain.Round;
import racingcar.domain.randomnumber.RandomIntegerGenerator;
import racingcar.io.Input.ConsoleInputHandler;
import racingcar.io.Input.InputHandler;
import racingcar.io.Output.ConsoleOutputHandler;
import racingcar.io.Output.OutputHandler;

public class Application {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        Cars cars = new Cars(new RandomIntegerGenerator(LOWER_BOUND, UPPER_BOUND));
        Round round = new Round();
        Racing racing = new Racing(inputHandler, outputHandler, cars, round);

        racing.start();
    }
}

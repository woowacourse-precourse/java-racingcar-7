package racingcar;

import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutPutHandler;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutPutHandler();

        RacingCar racingCar = new RacingCar(inputHandler, outputHandler);
        racingCar.run();
    }

}

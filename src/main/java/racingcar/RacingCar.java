package racingcar;

import racingcar.io.ConsoleInputHandler;

public class RacingCar {

    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();

    public void run(){
        String carListInput = consoleInputHandler.getCarListInput();
    }

}

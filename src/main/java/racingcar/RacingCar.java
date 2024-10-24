package racingcar;

import iohandler.InputHandler;
import iohandler.OutputHandler;

public class RacingCar {

    private InputHandler inputHandler = new InputHandler();
    private OutputHandler outputHandler = new OutputHandler();

    public void run() {
        try {
            outputHandler.showInputCarNameMessage();
            String inputCarName = inputHandler.getInputCarName();

            outputHandler.showInputRacingCountMessage();
            inputHandler.getInputRacingCount();


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}

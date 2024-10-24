package racingcar;

import io.CarNameInputHandler;
import io.InputHandler;
import io.OutputHandler;

import java.util.List;

public class RacingCar {

    private InputHandler inputHandler = new InputHandler();
    private OutputHandler outputHandler = new OutputHandler();
    private CarNameInputHandler carNameInputHandler = new CarNameInputHandler();

    public void run() {
        try {
            outputHandler.showInputCarNameMessage();
            String inputCarName = inputHandler.getInputCarName();
            List<String> separatedCarNameList = carNameInputHandler.getSeparatedCarNameList(inputCarName);

            outputHandler.showInputRacingCountMessage();
            int inputRacingCount = inputHandler.getInputRacingCount();


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}

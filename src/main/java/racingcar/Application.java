package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> cars = new HashMap<>();
        int numIterations = 0;

        InputHandler inputHandler = new InputHandler();
        RaceManager raceManager = new RaceManager();

        System.out.println(GuideMessage.INPUT_NAME.getMessage());
        cars = inputHandler.readCarNames();
        System.out.println(GuideMessage.INPUT_ITER.getMessage());
        numIterations = inputHandler.readIterNum();

        while (numIterations-- > 0) {
            cars = raceManager.raceOnce(cars);
        }
    }
}

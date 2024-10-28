package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> cars = new HashMap<>();
        List<String> winners = new ArrayList<>();
        int numIterations = 0;

        InputHandler inputHandler = new InputHandler();
        RaceManager raceManager = new RaceManager();
        OutputHandler outputHandler = new OutputHandler();

        System.out.println(GuideMessage.INPUT_NAME.getMessage());
        cars = inputHandler.readCarNames();
        System.out.println(GuideMessage.INPUT_ITER.getMessage());
        numIterations = inputHandler.readIterNum();

        System.out.println(GuideMessage.RACE_START.getMessage());
        while (numIterations-- > 0) {
            cars = raceManager.raceOnce(cars);
            outputHandler.printRaceState(cars);
        }

        winners = raceManager.findWinners(cars);
        System.out.print(GuideMessage.RACE_WINNER.getMessage());
        outputHandler.printRaceWinner(winners);
    }
}

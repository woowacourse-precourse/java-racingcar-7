package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        List<Car> carList = inputHandler.getCarName();
        int attemptNumber = inputHandler.getAttemtpNumber();

        RaceTrack raceTrack = new RaceTrack(carList);
        RaceController raceController = new RaceController(raceTrack, carList);

        raceController.run(attemptNumber);
        raceController.printWinnerList();
    }
}

package racingcar;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        try {
            SystemView systemView = new SystemView();

            String nameInput = systemView.printSystemNameInputMessage();
            Set<String> carNames = CarsNameParser.parse(nameInput);

            Cars cars = new Cars(carNames);
            RaceView raceView = new RaceView();
            cars.registerObserver(raceView);

            String trialInput = systemView.printSystemInputTrialMessage();
            InputValidator.validateTrialInput(trialInput);

            systemView.printSystemRaceStartMessage();
            cars.repeatGo(Integer.parseInt(trialInput));

            systemView.printSystemWinneMessage();
            raceView.displayWinner();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }

    }
}
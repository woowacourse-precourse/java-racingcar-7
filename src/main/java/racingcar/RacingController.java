package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private Race race;

    public void run() {
        String carNamesInput = InputHandler.getRacingCarNames();
        int numberOfAttempts = InputHandler.getNumberOfAttempts();

        List<RacingCar> racingCars = createRacingCars(carNamesInput);

        race = new Race(racingCars);
        race.startRacing(numberOfAttempts);

        OutputHandler.printWinners(race.getWinners());
    }

    private List<RacingCar> createRacingCars(String carNamesInput) {
        String[] names = carNamesInput.split(",");
        List<RacingCar> racingCars = new ArrayList<>();

        for (String name : names) {
            racingCars.add(new RacingCar(name.trim()));
        }

        return racingCars;
    }
}

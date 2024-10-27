package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        UserInput userInput = new UserInput();

        String[] racingCars = userInput.racingCarNameInput();
        Integer raceCount = userInput.raceCountInput();

        Race race = new Race(racingCars, raceCount);

        List<RacingCar> winners = race.race();
    }
}

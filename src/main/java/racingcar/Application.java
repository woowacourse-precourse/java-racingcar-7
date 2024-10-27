package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager();

        List<String> racerList = IOHandler.setRacerList();
        List<RacingCar> racingCars = CarFactory.createRacingCars(racerList);
        raceManager.startRace(racingCars,IOHandler.setRaceCycle());
    }
}
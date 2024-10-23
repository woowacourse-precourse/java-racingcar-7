package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager();
        CarFactory carFactory = new CarFactory();

        List<String> racerList = raceManager.getRacerList();
        List<RacingCar> racingCars = carFactory.createRacingCars(racerList);
        raceManager.startRace(racingCars);
    }
}

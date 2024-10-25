package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        RaceManager raceManager = new RaceManager(ioHandler);
        CarFactory carFactory = new CarFactory();


        List<String> racerList = ioHandler.setRacerList();
        List<RacingCar> racingCars = carFactory.createRacingCars(racerList);
        raceManager.startRace(racingCars,ioHandler.setRaceCycle());
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        RaceManager raceManager = new RaceManager();
        CarFactory carFactory = new CarFactory();

        List<String> strings = raceManager.setRacer();

        List<RacingCar> racingCars = carFactory.createRacingCars(strings);

        int cycle = raceManager.setRaceCycle();

        raceManager.startRace(cycle, racingCars);

    }



}

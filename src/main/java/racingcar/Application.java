package racingcar;

import racingcar.policy.RandomNumGeneratorImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> racerList = IOHandler.setRacerList();
        RandomNumGeneratorImpl randomNumGenerator = new RandomNumGeneratorImpl();

        RaceManager raceManager = new RaceManager(racerList,randomNumGenerator);
        raceManager.startRace(IOHandler.setRaceCycle());
    }
}
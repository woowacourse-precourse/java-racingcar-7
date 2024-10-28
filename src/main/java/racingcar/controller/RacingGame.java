package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.RaceProcess;

public class RacingGame {

    private final Race race;
    private final RaceProcess raceProcess;

    public RacingGame() {
        RaceSetup setup = new RaceSetup();
        this.race = setup.initializeRace();
        this.raceProcess = new RaceProcess(race);
    }

    public void start() {
        raceProcess.startRace(race.getTryCount());
        raceProcess.printFinalWinners();
    }
}

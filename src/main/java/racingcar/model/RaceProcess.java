package racingcar.model;

import racingcar.controller.ViewController;

public class RaceProcess {

    private final Race race;

    public RaceProcess(Race race) {
        this.race = race;
    }

    public void startRace(int moveCount) {
        ViewController.printStartRacePhrase();
        for (int i = 0; i < moveCount; i++) {
            race.playRound();
            ViewController.printRaceProcess(race.getCars());
        }
        ViewController.printWinners(race.getWinners());
    }
}
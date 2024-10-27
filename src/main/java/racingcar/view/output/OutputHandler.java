package racingcar.view.output;

import racingcar.domain.Race;

public class OutputHandler {
    public void printWinners(Race race) {
        System.out.println(RaceResultOutput.printWinners(race.getWinners()));
    }
}

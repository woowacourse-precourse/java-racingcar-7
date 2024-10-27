package racingcar.controller.handler;

import racingcar.controller.format.RaceResultFormatter;
import racingcar.domain.race.RaceResult;

public class ConsoleOutputHandler {

    private final RaceResultFormatter resultFormatter;

    public ConsoleOutputHandler(RaceResultFormatter resultFormatter) {
        this.resultFormatter = resultFormatter;
    }

    public void displayResults(RaceResult raceResult) {
        displayRaceProgress(raceResult);
        displayWinners(raceResult);
    }

    private void displayRaceProgress(RaceResult raceResult) {
        String raceProgress = resultFormatter.convertRaceProgressToString(raceResult.getRaces());
        System.out.print(raceProgress);
    }

    private void displayWinners(RaceResult raceResult) {
        String raceWinners = resultFormatter.convertWinnersToString(raceResult.getRaceWinnerList());
        System.out.print("최종 우승자 :");
        System.out.print(raceWinners);
    }
}

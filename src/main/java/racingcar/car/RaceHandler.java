package racingcar.car;

import java.util.List;

public class RaceHandler {

    private final RaceResultNotifier raceResultNotifier = new RaceResultNotifier();
    private final WinningCarRegistry winningCarRegistry = new WinningCarRegistry();


    public void race(List<Car> cars, long raceCount) {
        raceResultNotifier.announceUpcomingRaceResults();

        raceResultNotifier.announceRaceResult(cars, raceCount);

        long winningScore = raceResultNotifier.provideWinningScore(cars);

        winningCarRegistry.registerWinningCar(cars, winningScore);

        raceResultNotifier.announceWinner(winningCarRegistry.collectWinningCars());
    }


}

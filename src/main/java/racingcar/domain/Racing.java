package racingcar.domain;

import racingcar.value.RacingCarList;
import racingcar.value.TotalLaps;
import racingcar.value.WinnerPlayerList;

import java.util.function.Consumer;
import java.util.stream.Stream;

public final class Racing {

    private final RacingCarList racingCarList;
    private final TotalLaps totalLaps;
    private final RandomRace randomRace;

    private Racing(RacingCarList racingCarList, TotalLaps totalLaps, RandomRace randomRace) {
        this.racingCarList = racingCarList;
        this.totalLaps = totalLaps;
        this.randomRace = randomRace;
    }

    public static Racing of(RacingCarList racingCarList, TotalLaps totalLaps) {
        return new Racing(racingCarList, totalLaps, RandomRace.init());
    }

    public void play(final Consumer<RacingCarList> action) {
        Stream.generate(() -> this.randomRace)
            .limit(this.totalLaps.count())
            .forEach(randomRace -> {
                this.racingCarList.action(racingCar -> {
                    racingCar.moveForward(randomRace.createMoveForward());
                });

                this.racingCarList.actionPrint(action);
            });
    }

    public WinnerPlayerList getWinnerPlayerList() {
        return this.racingCarList.getWinnersList();
    }
}
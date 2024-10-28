package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public abstract class OutputView {

    public void calculateWinners(final List<RacingCar> carStateAfterGame) {

        final int maxLocation = getMaxLocationAfterGame(carStateAfterGame);

        final List<RacingCar> winners = findRacingCarWithMaxLocation(carStateAfterGame, maxLocation);

        displayOutput(winners);
    }

    private List<RacingCar> findRacingCarWithMaxLocation(final List<RacingCar> carStateAfterGame, final int maxLocation) {
        final List<RacingCar> winners = carStateAfterGame.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();
        return winners;
    }

    private int getMaxLocationAfterGame(final List<RacingCar> carStateAfterGame) {
        final int maxLocation = carStateAfterGame.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .getAsInt();
        return maxLocation;
    }

    abstract void displayOutput(final List<RacingCar> winners);
}

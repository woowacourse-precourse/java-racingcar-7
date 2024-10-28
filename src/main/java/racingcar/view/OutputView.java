package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public abstract class OutputView {

    public void calculateWinners(final List<RacingCar> carStateAfterGame) {

        final int maxLocation = carStateAfterGame.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .getAsInt();

        final List<RacingCar> winners = carStateAfterGame.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();

        displayOutput(winners);
    }

    abstract void displayOutput(final List<RacingCar> winners);
}

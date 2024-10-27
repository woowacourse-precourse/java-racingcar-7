package racingcar.model;

import racingcar.common.OutputController;

import java.util.List;

public class RacingCarList {

    private final List<RacingCar> racingCars;

    private RacingCarList(List<CarName> carNameSet) {
        racingCars = carNameSet.stream()
                .map(RacingCar::of)
                .toList();
    }

    public static RacingCarList of(List<CarName> carNameSet) {
        return new RacingCarList(carNameSet);
    }

    public void gameStartPerRound(RaceCount raceCount) {
        OutputController.printExecutionResultPromptMessage();

        int rounds = raceCount.raceCount();
        for (int i = 0; i < rounds; i++) {
            gameStartOneRound();
        }
    }

    public List<CarName> getWinningCars() {
        int maxPosition = racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getCarName)
                .toList();
    }

    private void gameStartOneRound() {
        racingCars.forEach(RacingCar::operatingMoveOrStop);
        OutputController.printRacingCarsPosition(racingCars);
    }
}

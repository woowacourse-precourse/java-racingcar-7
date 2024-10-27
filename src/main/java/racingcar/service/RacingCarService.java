package racingcar.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.car.RacingCar;
import racingcar.strategy.MoveStrategy;

public class RacingCarService {

    private final MoveStrategy moveStrategy;

    public RacingCarService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public List<RacingCar> generateRacingCarList(List<String> carNames) {
        return carNames.stream().map(RacingCar::of).toList();
    }

    public void runCarRacing(List<RacingCar> racingCars, int moveCount) {
        IntStream.range(0, moveCount).forEach(i -> {
            racingCars.forEach(racingCar -> racingCar.moveForwardOneStep(moveStrategy));
            racingCars.forEach(RacingCar::printMoveStatus);
            System.out.println();
        });
    }


    public List<RacingCar> getWinnerRacingCars(List<RacingCar> racingCars) {
        int maxDistance = racingCars.stream().mapToInt(RacingCar::getDistance).max().orElse(0);

        List<RacingCar> winners = racingCars.stream().filter(car -> car.getDistance() == maxDistance).toList();

        return winners;
    }
}

package racingcar.service.evaluator;

import racingcar.model.RacingCar;

import java.util.List;

public interface WinnerEvaluator {
    List<RacingCar> determineWinners(List<RacingCar> cars);
    Long findMaxDistance(List<RacingCar> cars);
    List<RacingCar> collectWinners(List<RacingCar> cars,Long maxDistance);
}

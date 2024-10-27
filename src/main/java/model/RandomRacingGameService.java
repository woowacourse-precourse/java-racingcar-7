package model;

import java.util.List;
import view.RacingCarView;

public class RandomRacingGameService implements RacingGameService {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int FORWARD_THRESHOLD = 4;

    private final RacingCarView racingCarView;

    public RandomRacingGameService() {
        this.racingCarView = new RacingCarView();
    }

    @Override
    public void progress(List<RacingCar> cars, int round) {
        int currentRound = 1;
        racingCarView.printResultMessage();
        while (currentRound <= round) {
            race(cars);
            racingCarView.printIntermediateResult(cars);
            currentRound++;
        }

        racingCarView.printWinner(findWinner(cars));
    }

    private List<RacingCar> findWinner(List<RacingCar> cars) {
        int maxDistance = cars.stream()
                .mapToInt(RacingCar::getDistance)
                .max().getAsInt();

        return cars.stream()
                .filter(car -> maxDistance == car.getDistance())
                .toList();
    }

    private void race(List<RacingCar> cars) {
        cars.stream()
                .filter(car -> RandomUtil.getRandomNumber(RANDOM_MIN, RANDOM_MAX) >= FORWARD_THRESHOLD)
                .forEach(RacingCar::increaseDistance);
    }
}

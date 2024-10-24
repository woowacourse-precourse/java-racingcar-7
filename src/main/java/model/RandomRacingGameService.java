package model;

import java.util.List;

public class RandomRacingGameService implements RacingGameService {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int FORWARD_THRESHOLD = 4;

    @Override
    public void progress(List<RacingCar> cars, long round) {
        long currentRound = 1;
        while (currentRound < round) {
            race(cars);
            currentRound++;
        }
    }

    private void race(List<RacingCar> cars) {
        cars.stream()
                .filter(car -> RandomUtil.getRandomNumber(RANDOM_MIN, RANDOM_MAX) >= FORWARD_THRESHOLD)
                .forEach(RacingCar::increaseDistance);
    }
}

package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.RacingGameConstants;
import racingcar.model.RacingCar;

public class RacingGameService {

    private final List<RacingCar> racingCars;

    public RacingGameService(List<String> carNames) {
        this.racingCars = initializeCars(carNames);
    }

    private List<RacingCar> initializeCars(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void startRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceOnce();
        }
    }

    private void raceOnce() {
        for (RacingCar car : racingCars) {
            moveCarIfPossible(car);
        }
    }

    private void moveCarIfPossible(RacingCar car) {
        int randomValue = pickRandomNumber();
        if (canMove(randomValue)) {
            car.advance();
        }
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean canMove(int randomValue) {
        return randomValue >= RacingGameConstants.MOVE_THRESHOLD.getValue();
    }

    public List<RacingCar> findWinners() {
        int maxPosition = findMaxPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

}

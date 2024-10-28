package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.exception.ErrorMessage;
import racingcar.exception.ExceptionHandler;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RacingCarService {

    public void registerRacingCars(final Collection<RacingCar> racingCars, final Collection<String> carNames) {
        checkDuplicatedName(carNames);
        carNames.stream()
                .map(RacingCar::createRacingCar)
                .forEach(racingCars::add);
    }

    public void racingGame(final Collection<RacingCar> racingCars) {
        racingCars.forEach(this::race);
    }

    public List<RacingCar> findWinner(final Collection<RacingCar> racingCars) {
        List<RacingCar> winners = new LinkedList<>();
        int biggestScore = 0;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getRaceScore() > biggestScore) {
                biggestScore = racingCar.getRaceScore();
                winners.clear();
                winners.add(racingCar);
                continue;
            }
            if (racingCar.getRaceScore() == biggestScore) {
                winners.add(racingCar);
            }
        }
        return winners;
    }

    private void race(RacingCar racingCar) {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            racingCar.move();
        }
    }

    private void checkDuplicatedName(final Collection<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            ExceptionHandler.handleIllegalArgumentException(ErrorMessage.DUPLICATED_NAME);
        }
    }
}

package racingcar.mvc.controller.racingGameManager;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.mvc.model.observer.CarRacer;
import racingcar.mvc.model.observer.Racer;
import racingcar.mvc.model.subject.RacingGameRound;
import racingcar.mvc.validation.input.CarNameValidator;

public class CarRacingGameManager extends RacingGameManager {
    @Override
    public List<Racer> createRacers(String nameString) {
        List<Racer> racers = new ArrayList<>();

        CarNameValidator.isValid(nameString);

        for (String name : nameString.split(CarNameValidator.NAME_DELIMITER)) {
            racers.add(new CarRacer(name));
        }

        return racers;
    }

    @Override
    public RacingGameRound setGameRound(RacingGameRound gameRound, List<Racer> racers) {
        this.gameRound = gameRound;

        for (Racer racer : racers) {
            gameRound.registerObserver(racer);
        }

        return this.gameRound;
    }

    @Override
    public List<Racer> goRound() {
        gameRound.notifyObservers();

        return gameRound.getRacers();
    }

    public List<Racer> getWinners() {
        List<Racer> racers = gameRound.getRacers();

        Collections.sort(racers, Comparator.comparing(Racer::getDistance));

        BigInteger winnerDistance = findWinnerDistance(racers);

        return racers.subList(lowerBound(racers, winnerDistance), upperBound(racers, winnerDistance));
    }

    private BigInteger findWinnerDistance(List<Racer> racers) {
        return racers.getLast().getDistance();
    }

    //인덱스 타입 생각해보자
    private int upperBound(List<Racer> racers, BigInteger winnerDistance) {
        int begin = 0;
        int end = racers.size();

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (racers.get(mid).getDistance().compareTo(winnerDistance) <= 0) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private int lowerBound(List<Racer> racers, BigInteger winnerDistance) {
        int begin = 0;
        int end = racers.size();

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (racers.get(mid).getDistance().compareTo(winnerDistance) >= 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }

}

package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import racingcar.domain.Car;
import racingcar.domain.Round;

public class RoundRepository {
    private static final String ERROR_MESSAGE_RACE_NOT_STARTED = "경주를 진행하지 않았습니다.";

    private final List<Round> rounds;

    public RoundRepository() {
        this.rounds = new ArrayList<>();
    }

    public void save(Round round) {
        rounds.add(round);
    }

    public List<Car> findWinnerCars() {
        return getLastRound().pickWinners();
    }

    public List<Round> findAllRounds() {
        return rounds.stream()
                .toList();
    }

    private Round getLastRound() {
        try {
            return rounds.getLast();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RACE_NOT_STARTED);
        }
    }

}

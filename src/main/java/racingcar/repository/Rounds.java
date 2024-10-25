package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Round;

public class Rounds {
    private static final String ERROR_MESSAGE_RACE_NOT_STARTED = "경주를 진행하지 않았습니다.";

    private final List<Round> rounds;

    public Rounds() {
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
        if (rounds.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RACE_NOT_STARTED);
        }
        return rounds.get(rounds.size() - 1);
    }

}

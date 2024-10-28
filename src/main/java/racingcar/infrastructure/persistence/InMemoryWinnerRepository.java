package racingcar.infrastructure.persistence;

import racingcar.domain.winner.Winner;
import racingcar.domain.winner.repository.WinnerRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryWinnerRepository implements WinnerRepository {
    private static final InMemoryWinnerRepository instance = new InMemoryWinnerRepository();
    private final List<Winner> winners;

    private InMemoryWinnerRepository() {
        this.winners = new ArrayList<>();
    }

    public static InMemoryWinnerRepository getInstance(){
        return  instance;
    }

    public void saveWinner(Winner winner) {
        winners.add(winner);
    }

    public List<Winner> getWinners() {
        return winners;
    }
}

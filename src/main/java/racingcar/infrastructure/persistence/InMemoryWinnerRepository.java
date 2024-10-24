package racingcar.infrastructure.persistence;

import racingcar.domain.winner.Winner;
import racingcar.domain.winner.repository.WinnerRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryWinnerRepository implements WinnerRepository {
    private final List<Winner> winners;

    public InMemoryWinnerRepository() {
        this.winners = new ArrayList<>();
    }

    // TODO : 우승자 결과 저장
    public void saveWinner(Winner winner) {

    }

    // TODO : 우승자 반환
    public List<Winner> getWinners() {
        return null;
    }
}

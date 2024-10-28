package racingcar.domain.winner.repository;

import racingcar.domain.winner.Winner;

import java.util.List;

public interface WinnerRepository {
    void saveWinner(Winner winner);

    List<Winner> getWinners();
}

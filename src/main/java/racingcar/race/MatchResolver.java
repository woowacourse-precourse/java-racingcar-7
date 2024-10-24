package racingcar.race;

import java.util.List;

public class MatchResolver {

    public <T extends Player<T>> List<T> determineWinner(Players<T> players) {
        List<T> SortedByWinner = players.getSortedByWinner();

        T firstWinner = SortedByWinner.getFirst();
        return SortedByWinner.stream()
                .filter((player) -> !player.isLoser(firstWinner))
                .toList();
    }

}

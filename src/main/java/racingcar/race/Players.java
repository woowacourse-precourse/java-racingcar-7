package racingcar.race;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Players<T extends Player<T>> {

    private final List<T> players;

    public Players(List<T> players) {
        this.players = players;
    }

    public void playEach() {
        players.forEach(Player::play);
    }

    public List<T> getSortedByWinner() {
        List<T> lineup = new ArrayList<>(players);
        lineup.sort(Comparator.reverseOrder());
        return lineup;
    }

}

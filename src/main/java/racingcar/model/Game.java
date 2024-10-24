package racingcar.model;

import java.util.List;

public interface Game {
    void addPlayer(Player player);
    void progress();
    List<String> getWinner();
}

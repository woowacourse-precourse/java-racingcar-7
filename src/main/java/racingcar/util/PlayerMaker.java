package racingcar.util;

import racingcar.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerMaker {

    private final static int SET_SCORE = 0;

    public List<Player> createPlayer(String players) {
        List<Player> playerList = new ArrayList<>();
        for (String player : players.split(",")) {
            playerList.add(new Player(player, SET_SCORE));
        }
        return playerList;
    }
}

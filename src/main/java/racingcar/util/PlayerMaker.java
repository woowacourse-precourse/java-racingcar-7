package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Player;

public class PlayerMaker {

    private final static int SET_SCORE = 0;
    private final static String DELIMITER = ",";

    public static List<Player> createPlayer(String players) {
        List<Player> playerList = new ArrayList<>();

        // 입력: poib, java
        for (String player : players.split(DELIMITER)) {
            playerList.add(new Player(player, SET_SCORE));
        }
        return playerList;
    }
}

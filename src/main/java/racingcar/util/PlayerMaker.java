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
            // 이름에 공백이 있을 수 있기 때문에 제거해준다.
            playerList.add(new Player(player.trim(), SET_SCORE));
        }
        return playerList;
    }
}

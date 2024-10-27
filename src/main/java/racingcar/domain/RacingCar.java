package racingcar.domain;

import java.util.List;
import racingcar.util.PlayerMaker;
import racingcar.util.Racing;
import racingcar.util.RandomNumberMaker;
import racingcar.util.WinnerMaker;

public class RacingCar {

    private final List<Player> playerList;

    public RacingCar(String players) {
        playerList = PlayerMaker.createPlayer(players);
    }

    public List<Player> racing() {
        for (Player player : playerList) {
            Racing.move(player, RandomNumberMaker.randomNumber());
        }
        return playerList;
    }

    public String createWinner() {
        return WinnerMaker.createWinner(playerList);
    }
}

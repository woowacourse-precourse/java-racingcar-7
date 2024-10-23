package racingcar.domain;

import racingcar.util.PlayerMaker;
import racingcar.util.Racing;
import racingcar.util.RandomNumberMaker;
import racingcar.util.WinnerMaker;

import java.util.List;

public class RacingCar {

    private final List<Player> playerList;

    public RacingCar(String players) {
        playerList = PlayerMaker.createPlayer(players);
    }

    public List<Player> racing() {
        for (Player player : playerList) {
            Racing.racing(player, RandomNumberMaker.randomNumber());
        }
        return playerList;
    }

    public String createWinner() {
        return WinnerMaker.createWinner(playerList);
    }
}

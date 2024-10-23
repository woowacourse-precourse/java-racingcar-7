package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GameContext {

    private final List<Player> players;
    private final int round;

    private GameContext(List<Player> players, int round) {
        if (players.size() > 100) {
            throw new IllegalArgumentException();
        }

        if (round > 10_000 || round <= 0) {
            throw new IllegalArgumentException();
        }
        this.players = players;
        this.round = round;
    }
    public static GameContext getGameContext(String playerNameInput, int round) {
        List<Player> players = new ArrayList<>();
        for (String playerName : playerNameInput.split(",")) {
            players.add(new Player(playerName, () -> Randoms.pickNumberInRange(0, 9)));
        }
        return new GameContext(players, round);
    }
    public static GameContext getGameContext(List<Player> players, int round) {
        return new GameContext(players, round);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getRound() {
        return round;
    }

    public void run(){
        for (int i = 0; i < round; i++) {
            playRound();
        }
    }

    public List<String> findWinners() {
        int topPlayerPlace = 0;
        List<Player> winner = new ArrayList<>();
        for (Player player : players) {
            if (player.getPlace() > topPlayerPlace) {
                winner.clear();
                winner.add(player);
                topPlayerPlace = player.getPlace();
            } else if (player.getPlace() == topPlayerPlace) {
                winner.add(player);
            }
        }
        return getWinnersNameList(winner);
    }

    private void playRound() {
        for (Player player : players) {
            player.move();
            player.printPlace();
        }
        System.out.println();
    }

    private List<String> getWinnersNameList(List<Player> winner) {
        return winner.stream().map(Player::getPlayerName).toList();
    }
}

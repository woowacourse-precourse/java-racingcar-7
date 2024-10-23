package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GameContext {

    private final List<Player> players = new ArrayList<>();
    private final int round;

    public GameContext(String playerInput, int round) {
        for (String playerName : playerInput.split(",")) {
            if (playerName.length() > 5) {
                throw new IllegalArgumentException();
            }
            players.add(new Player(playerName));
        }
        if (players.size() > 100) {
            throw new IllegalArgumentException();
        }

        if (round > 10_000 || round <= 0) {
            throw new IllegalArgumentException();
        }
        this.round = round;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getRound() {
        return round;
    }

    public void run(Supplier<Integer> pickUpLogic){
        for (int i = 0; i < round; i++) {
            playRound(pickUpLogic);
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

    private void playRound(Supplier<Integer> pickUpLogic) {
        for (Player player : players) {
            int pick = pickUpLogic.get();
            player.move(pick);
            player.printPlace();
        }
        System.out.println();
    }

    private List<String> getWinnersNameList(List<Player> winner) {
        return winner.stream().map(Player::getPlayerName).toList();
    }
}

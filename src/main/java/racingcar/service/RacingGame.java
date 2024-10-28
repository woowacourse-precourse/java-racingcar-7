package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.Player;
import racingcar.dto.RoundResult;
import racingcar.utils.CustomNumberGenerator;
import racingcar.utils.NumberGenerator;

public class RacingGame {
    private final List<Player> players;
    private final int roundCount;
    private final CustomNumberGenerator customNumberGenerator;
    private final List<RoundResult> roundResults = new ArrayList<>();

    public RacingGame(List<Player> players, int roundCount) {
        this.players = players;
        this.roundCount = roundCount;
        customNumberGenerator = new CustomNumberGenerator();
    }

    public void play() {
        for (int round = 1; round <= roundCount; round++) {
            playOneRound();
            roundResults.add(RoundResult.createRoundResult(round, players));
        }
    }

    public void playOneRound() {
        for (Player player : players) {
            moveCarByRule(player, customNumberGenerator);
        }
    }

    public void moveCarByRule(Player player, NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generateInteger();
        int step = 1;

        if (randomNumber >= 4) {
            player.moveCar(step);
        }
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinners() {
        int maxPosition = Collections.max(
                players.stream().map(Player::getPosition).toList()
        );
        return players.stream()
                .filter(player -> player.getPosition() == maxPosition)
                .map(Player::getCarName)
                .toList();
    }
}

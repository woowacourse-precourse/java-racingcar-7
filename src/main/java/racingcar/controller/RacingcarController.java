package racingcar.controller;

import java.util.List;
import racingcar.view.View;

public class RacingcarController {
    private final View view;

    public RacingcarController(View view) {
        this.view = view;
    }

    public void run() {
        var player = getPlayer();

        var round = getRound();
    }

    private int getRound() {
        var input = view.roundInput();
        int round;
        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return round;
    }

    private List<String> getPlayer() {
        var input = view.playerInput();
        var playerArray = input.split(",");
        var players = List.of(playerArray);
        return players;
    }
}

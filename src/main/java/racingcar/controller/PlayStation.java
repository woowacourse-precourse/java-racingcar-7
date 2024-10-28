package racingcar.controller;

import racingcar.service.Game;

import java.util.List;

public class PlayStation {

    private final Game game;

    public PlayStation(Game game) {
        this.game = game;
    }

    public List<String> run(List<String> names, Integer round) {
        return game.play(names, round);
    }

}

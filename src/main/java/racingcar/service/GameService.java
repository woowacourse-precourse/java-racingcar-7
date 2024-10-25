package racingcar.service;

import racingcar.domain.Game;
import racingcar.domain.Input;

public class GameService {

    private Game game;
    private static Input input;

    public GameService(Input input, Game game) {
        GameService.input = input;
        this.game = game;
    }

    public void addCarName() {
        String[] names = input.getNames().split(",");

        for (String name : names) {
            if (game.getCars().containsKey(name)) throw new IllegalArgumentException("중복된 이름입니다.");

            game.getCars().put(name, 0);
        }
    }
}

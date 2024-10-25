package racingcar.racing.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final Game game;
    private final List<Car> cars = new ArrayList<>();

    public Winner(Game game) {
        this.game = game;
    }
}

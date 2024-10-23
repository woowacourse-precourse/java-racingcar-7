package racingcar;

import java.util.ArrayList;

public class Race {

    private final int rounds;
    private final List<Car> players = new ArrayList<>();

    public Race(int rounds) {
        this.rounds = rounds;
    }
}

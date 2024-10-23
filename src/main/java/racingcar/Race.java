package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final int rounds;
    private final List<Car> players = new ArrayList<>();

    public Race(int rounds) {
        this.rounds = rounds;
    }
}

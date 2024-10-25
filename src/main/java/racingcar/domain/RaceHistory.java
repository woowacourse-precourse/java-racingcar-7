package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceHistory {

    private final List<RaceRound> rounds;

    public RaceHistory() {
        this.rounds = new ArrayList<>();
    }

    public void addRound(RaceRound round) {
        rounds.add(round);
    }

    public List<RaceRound> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

}

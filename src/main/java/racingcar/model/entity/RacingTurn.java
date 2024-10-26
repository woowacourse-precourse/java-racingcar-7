package racingcar.model.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public final class RacingTurn {

    private final LinkedHashMap<String, Supplier<Integer>> turn;

    public RacingTurn(LinkedHashMap<String, Supplier<Integer>> turn) {
        this.turn = turn;
    }

    public Set<Map.Entry<String, Supplier<Integer>>> getEntrySet() {
        return turn.entrySet();
    }

}

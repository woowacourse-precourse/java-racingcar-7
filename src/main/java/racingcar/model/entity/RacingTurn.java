package racingcar.model.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/** 자동차 이름과 자동차 이동 전략을 매핑함 */
public final class RacingTurn {

    private final LinkedHashMap<String, Supplier<Integer>> turn;

    public RacingTurn(LinkedHashMap<String, Supplier<Integer>> turn) {
        this.turn = turn;
    }

    public Set<Map.Entry<String, Supplier<Integer>>> getEntrySet() {
        return turn.entrySet();
    }

}

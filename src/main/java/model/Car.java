package model;

import java.util.List;

public class MoveCount {

    private List<Integer> MoveCount;

    private final int VALUE = 0;

    public Integer sumMoveCount() {
        return MoveCount.stream()
                .reduce(VALUE, Integer::sum);
    }
}

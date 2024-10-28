package racingcar.domain;

import java.util.List;

public class Registration {

    private final List<String> lineup;
    private final Long lapCount;

    public Registration(List<String> lineup, Long lapCount) {
        this.lineup = lineup;
        this.lapCount = lapCount;
    }

    public List<String> getLineup() {
        return lineup;
    }

    public Long getLapCount() {
        return lapCount;
    }
}

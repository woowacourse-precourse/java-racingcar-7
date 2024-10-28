package racingcar.dto;

import java.util.List;

public class RaceRequestDTO {

    private final List<String> names;
    private final long times;

    public RaceRequestDTO(List<String> names, long times) {
        this.names = names;
        this.times = times;
    }

    public List<String> getNames() {
        return names;
    }

    public long getTimes() {
        return times;
    }
}

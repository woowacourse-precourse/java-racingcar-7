package racingcar.dto;

import java.util.List;

public class InputDto {
    private List<String> carnames;
    private Integer totalRound;

    public InputDto(List<String> carnames, Integer totalRound) {
        this.carnames = carnames;
        this.totalRound = totalRound;
    }

    public Integer getTotalRound() {
        return totalRound;
    }

    public List<String> getCarnames() {
        return carnames;
    }
}

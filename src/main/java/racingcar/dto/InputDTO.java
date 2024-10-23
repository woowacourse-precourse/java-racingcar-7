package racingcar.dto;

import java.util.List;

public class InputDTO {

    private final List<String> racerNames;
    private final int totalCount;

    public InputDTO(List<String> racerNames, int totalCount) {
        this.racerNames = racerNames;
        this.totalCount = totalCount;
    }

    public List<String> getRacerNames() {
        return racerNames;
    }

    public int getTotalCount() {
        return totalCount;
    }
}

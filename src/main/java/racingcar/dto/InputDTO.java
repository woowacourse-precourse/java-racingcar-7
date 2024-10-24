package racingcar.dto;

import java.util.List;

public class InputDTO {

    private final List<String> racerNames;
    private final int totalTrialCount;

    public InputDTO(List<String> racerNames, Integer totalTrialCount) {
        this.racerNames = racerNames;
        this.totalTrialCount = totalTrialCount;
    }

    public List<String> getRacerNames() {
        return racerNames;
    }

    public int getTotalTrialCount() {
        return totalTrialCount;
    }
}

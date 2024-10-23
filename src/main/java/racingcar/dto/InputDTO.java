package racingcar.dto;

import java.util.List;

public class InputDTO {

    private final List<String> racerNames;
    private final int trialCount;

    public InputDTO(List<String> racerNames, int trialCount) {
        this.racerNames = racerNames;
        this.trialCount = trialCount;
    }

    public List<String> getRacerNames() {
        return racerNames;
    }

    public int getTrialCount() {
        return trialCount;
    }
}

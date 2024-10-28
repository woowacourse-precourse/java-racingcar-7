package racingcar.dto;

import static racingcar.util.Validator.validateDuplicatedName;
import static racingcar.util.Validator.validatePositive;

import java.util.List;

public class InputDTO {

    private final List<String> racerNames;
    private final Integer totalTrialCount;

    public InputDTO(List<String> racerNames, Integer totalTrialCount) {
        this.racerNames = validateDuplicatedName(racerNames);
        this.totalTrialCount = validatePositive(totalTrialCount);
    }

    public List<String> getRacerNames() {
        return racerNames;
    }

    public int getTotalTrialCount() {
        return totalTrialCount;
    }
}

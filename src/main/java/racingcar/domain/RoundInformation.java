package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RoundInformation {
    private final Round round;
    private final List<ProgressedInformation> progressedInformations;

    public RoundInformation(Round round, List<ProgressedInformation> progressedInformations) {
        this.round = round;
        this.progressedInformations = progressedInformations;
    }

    public List<ProgressedInformation> getProgressedInformations() {
        return Collections.unmodifiableList(this.progressedInformations);
    }
}

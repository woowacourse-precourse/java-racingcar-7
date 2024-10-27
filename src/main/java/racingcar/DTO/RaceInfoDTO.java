package racingcar.DTO;

import java.util.List;
import racingcar.Util.Exception.ErrorMessage;
import racingcar.Validation.NameValidation;
import racingcar.Validation.NumberOfTrialValidation;

public class RaceInfoDTO {
    private List<String> carNames;
    private int trialCount;

    public RaceInfoDTO(List<String> carNames, int trialCount) {
        if (NameValidation.isLongName(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG.getMessage());
        }
        if (NameValidation.hasDuplicate(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATE.getMessage());
        }
        if (NumberOfTrialValidation.isNegative(trialCount)) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_NEGATIVE.getMessage());
        }
        if (NumberOfTrialValidation.isZero(trialCount)) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_ZERO.getMessage());
        }
        this.carNames = carNames;
        this.trialCount = trialCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTrialCount() {
        return trialCount;
    }
}

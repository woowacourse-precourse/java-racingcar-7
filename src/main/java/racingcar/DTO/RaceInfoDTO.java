package racingcar.DTO;

import java.util.List;

public class RaceInfoDTO {
    private List<String> carNames;
    private int trialCount;

    public RaceInfoDTO(List<String> carNames, int trialCount) {
        // TODO - 검증부 구현
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

package racingcar.dto;

import static racingcar.util.Constants.OUTPUT_DELIMITER;

import java.util.List;
import racingcar.model.RacingCar;

public class OutputDTO {

    private final List<RacingCar> raceResult;
    private final List<String> winners;
    private final Integer totalTrialCount;

    public OutputDTO(List<RacingCar> raceResult, List<String> winners, Integer totalTrialCount) {
        this.raceResult = raceResult;
        this.winners = winners;
        this.totalTrialCount = totalTrialCount;
    }

    public List<RacingCar> getResult() {
        return raceResult;
    }

    public String getWinners() {
        return String.join(OUTPUT_DELIMITER, winners);
    }

    public Integer getTotalTrialCount() {
        return totalTrialCount;
    }
}

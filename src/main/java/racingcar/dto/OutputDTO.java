package racingcar.dto;

import static racingcar.util.ConstantData.OUTPUT_DELIMITER;

import java.util.List;
import racingcar.model.RacingCar;

public class OutputDTO {

    private final List<RacingCar> raceResult;
    private final List<String> winners;

    public OutputDTO(List<RacingCar> raceResult, List<String> winners) {
        this.raceResult = raceResult;
        this.winners = winners;
    }

    public List<RacingCar> getRaceResult() {
        return raceResult;
    }

    public String getWinners() {
        return String.join(OUTPUT_DELIMITER, winners);
    }
}

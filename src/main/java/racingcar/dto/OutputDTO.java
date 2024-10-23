package racingcar.dto;

import static racingcar.util.ConstantData.OUTPUT_DELIMITER;

import java.util.List;
import racingcar.model.RacingCar;

public class OutputDTO {

    private final List<RacingCar> raceRecord;
    private final List<String> winners;

    public OutputDTO(List<RacingCar> raceRecord, List<String> winners) {
        this.raceRecord = raceRecord;
        this.winners = winners;
    }

    public List<RacingCar> getRaceRecord() {
        return raceRecord;
    }

    public String getWinners() {
        return String.join(OUTPUT_DELIMITER, winners);
    }
}

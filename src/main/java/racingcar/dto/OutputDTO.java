package racingcar.dto;

import static racingcar.util.ConstantData.OUTPUT_DELIMITER;

import java.util.List;
import racingcar.model.CarRacer;

public class OutputDTO {

    private final List<CarRacer> raceRecord;
    private final List<String> winners;

    public OutputDTO(List<CarRacer> raceRecord, List<String> winners) {
        this.raceRecord = raceRecord;
        this.winners = winners;
    }

    public List<CarRacer> getRaceRecord() {
        return raceRecord;
    }

    public String getWinners() {
        return String.join(OUTPUT_DELIMITER, winners);
    }
}

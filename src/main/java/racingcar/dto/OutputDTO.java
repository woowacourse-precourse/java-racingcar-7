package racingcar.dto;

import java.util.List;
import racingcar.model.CarRacer;

public class OutputDTO {

    private final List<CarRacer> raceRecord;
    private final List<String> winners;

    public OutputDTO(List<CarRacer> raceRecord, List<String> winners) {
        this.raceRecord = raceRecord;
        this.winners = winners;
    }

    public List<CarRacer> getResult() {
        return raceRecord;
    }

    public String getWinners() {
        return String.join(", ", winners);
    }
}

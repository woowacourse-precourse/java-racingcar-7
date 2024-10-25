package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;

public class RaceRecord {

    private List<RaceRoundRecord> raceRoundRecords;

    public RaceRecord(RaceRoundRecord raceRoundRecords) {
        if (raceRoundRecords == null) {
            throw new IllegalArgumentException("reaceRoundRecords가 null입니다");
        }
        this.raceRoundRecords = new ArrayList<>(List.of(raceRoundRecords));
    }

    public void add(RaceRoundRecord raceRoundRecord) {
        raceRoundRecords.add(raceRoundRecord);
    }

    public List<RaceRoundRecord> getRaceRoundRecords() {
        return raceRoundRecords;
    }
}

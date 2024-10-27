package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceRecords {

    private static final String FORWARD_SYMBOL = "-";
    private final List<String> raceRecords;

    public RaceRecords() {
        this.raceRecords = new ArrayList<>();
    }

    public void initializeRecords(int raceCount) {
        for (int round = 0; round < raceCount; round++) {
            raceRecords.add("");
        }
    }

    public void recordPrevRaceByRound(int round) {
        String prevRaceRecord = raceRecords.get(round - 1);
        raceRecords.add(round, prevRaceRecord);
    }

    public void recordRaceByRound(int round) {
        String prevRaceRecord = raceRecords.get(round);
        raceRecords.add(round, prevRaceRecord + FORWARD_SYMBOL);

    }

    public String getByRound(int round) {
        return raceRecords.get(round);
    }

    public int lengthByRound(int round) {
        return raceRecords.get(round).length();
    }
}

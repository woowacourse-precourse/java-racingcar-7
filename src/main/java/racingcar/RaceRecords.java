package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceRecords {

    private static final String FORWARD_SYMBOL = "-";
    private final List<List<String>> raceRecords;

    public RaceRecords() {
        this.raceRecords = new ArrayList<>();
    }

    public void initializeRecords(int raceCount) {
        for (int round = 0; round < raceCount; round++) {
            raceRecords.add(new ArrayList<>());
        }
    }

    public void recordPrevRaceByRound(int round) {
        List<String> prevRace = raceRecords.get(round - 1);
        List<String> currentRace = raceRecords.get(round);

        for (String record : prevRace) {
            currentRace.add(record);
        }
    }

    public void recordRaceByRound(int round) {
        getByRound(round).add(FORWARD_SYMBOL);
    }

    public List<String> getByRound(int round) {
        return raceRecords.get(round);
    }

    public int getLastRaceRecord() {
        List<String> lastRaceRecord = getByRound(raceRecords.size() - 1);
        return lastRaceRecord.size();
    }
}

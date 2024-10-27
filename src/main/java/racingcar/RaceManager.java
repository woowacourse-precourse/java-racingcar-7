package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {

    public List<String> calculateWinners(RaceCars raceCars, int raceCount) {

        int maxRecord = findMaxRecord(raceCars, raceCount);
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < raceCars.size(); i++) {
            Car car = raceCars.getCarByIndex(i);
            RaceRecords raceRecords = car.getRaceRecords();
            int lastRaceRecord = raceRecords.lengthByRound(raceCount - 1);

            if (lastRaceRecord == maxRecord) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int findMaxRecord(RaceCars raceCars, int raceCount) {
        int maxRecord = 0;

        for (int i = 0; i < raceCars.size(); i++) {
            Car car = raceCars.getCarByIndex(i);
            RaceRecords raceRecords = car.getRaceRecords();
            int lastRaceRecord = raceRecords.lengthByRound(raceCount - 1);

            maxRecord = Math.max(maxRecord, lastRaceRecord);
        }

        return maxRecord;
    }
}
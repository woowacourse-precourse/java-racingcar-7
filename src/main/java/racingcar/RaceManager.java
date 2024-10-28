package racingcar;

import racingcar.model.Car;
import racingcar.model.RaceCars;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {

    public List<String> calculateWinners(RaceCars raceCars, int raceCount) {

        List<String> winners = new ArrayList<>();
        int maxRecord = Integer.MIN_VALUE;

        for (int i = 0; i < raceCars.size(); i++) {
            Car car = raceCars.getCarByIndex(i);
            String carName = car.getName();
            int lastRaceRecord = car.getRecordLengthByRound(raceCount - 1);

            if (lastRaceRecord > maxRecord) {
                maxRecord = lastRaceRecord;
                winners.clear();
                winners.add(carName);
            } else if (lastRaceRecord == maxRecord) {
                winners.add(carName);
            }
        }

        return winners;
    }
}
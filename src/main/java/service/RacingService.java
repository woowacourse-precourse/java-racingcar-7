package service;

import policy.RacingPolicy;
import repository.Repository;

public interface RacingService {
    String racingStart();
    Repository getRaceStatusRepository();
    RacingPolicy getRacingPolicy();
    void generateRacer(String[] splitNames);
    String runRace(String[] splitNames);
    String fineRaceWinner();
}

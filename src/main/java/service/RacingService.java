package service;

import dto.RacingOutputDTO;
import policy.RacingPolicy;
import repository.Repository;

public interface RacingService {
    RacingOutputDTO racingStart();
    Repository getRaceStatusRepository();
    RacingPolicy getRacingPolicy();
    void generateRacer(String[] splitNames);
    String runRace(String[] splitNames);
    String fineRaceWinner();
}

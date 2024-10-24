package service;

import dto.RaceOutputDTO;
import policy.RacingPolicy;
import repository.Repository;

public interface RacingService {
    RaceOutputDTO racingStart();
    Repository getRaceStatusRepository();
    RacingPolicy getRacingPolicy();
    void generateRacer(String[] splitNames);
    String runRace(String[] splitNames);
    String fineRaceWinner();
}

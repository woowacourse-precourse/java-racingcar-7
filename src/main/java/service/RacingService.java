package service;

import dto.RacingOutputDTO;

public interface RacingService {
    RacingOutputDTO racingStart();
    void generateRacer(String[] splitNames);
    String runRace(String[] splitNames);
    String fineRaceWinner();
}

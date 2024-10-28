package racingcar.domain;

import racingcar.dto.RacingOutputDTO;

public interface Racing {

    RacingOutputDTO racingStart();

    void generateRacer(String[] splitNames);
    String runRace();

    String fineRaceWinner(Long round);

}

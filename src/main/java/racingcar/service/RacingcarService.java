package racingcar.service;

import racingcar.model.Racingcar;

import java.util.List;

public interface RacingcarService {
    void startRaceByCount(List<Racingcar> racingcars);
    List<Racingcar> determineWinner(List<Racingcar> racingcars);
}

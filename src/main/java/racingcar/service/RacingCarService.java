package racingcar.service;

import racingcar.model.Car;

public interface RacingCarService {
    void startRace();

    String getWinner();

    void printRacing(Car car, Integer randomNumber);
}

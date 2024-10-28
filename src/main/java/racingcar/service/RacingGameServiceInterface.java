package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public interface RacingGameServiceInterface {

  void validateCarNames(String[] carNames);

  void validateTrialCount(int trialCount);

  List<Car> createCars(String[] carNames);

  void playRound(List<Car> cars);

  List<Car> findWinners(List<Car> cars);
}

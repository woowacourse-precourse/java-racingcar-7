package racingcar.domain.game;

import java.util.List;
import racingcar.error.ErrorMessages;
import racingcar.view.CarStatusDTO;
import racingcar.strategy.MoveStrategy;
import racingcar.domain.Constants;

public class Game {

  private final Cars cars;
  private final GameCount gameCount;

  public Game(String carNamesInput, String gameCountInput, MoveStrategy moveStrategy) {
    validateCarNamesInput(carNamesInput);
    validateCarNamesInput(gameCountInput);
    List<String> carNames = List.of(carNamesInput.split(Constants.CAR_NAME_DELIMITER));
    this.cars = new Cars(carNames, moveStrategy);
    this.gameCount = new GameCount(gameCountInput);
  }

  private void validateCarNamesInput(String input) {
    validateNotNull(input);
    validateNotEmpty(input);
  }

  private void validateNotNull(String input) {
    if (input == null) {
      throw new IllegalArgumentException(ErrorMessages.INPUT_NULL.getMessage());
    }
  }

  private void validateNotEmpty(String input) {
    if (input.trim().isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.INPUT_EMPTY.getMessage());
    }
  }


  public void playRound() {
    this.cars.moveCars();
    this.gameCount.decrement();
  }

  public boolean canPlay() {
    return this.gameCount.canPlay();
  }

  public List<CarStatusDTO> getCurrentStatuses() {
    return this.cars.getCarStatuses();
  }

  public List<String> getWinners() {
    return this.cars.findWinners();
  }
}

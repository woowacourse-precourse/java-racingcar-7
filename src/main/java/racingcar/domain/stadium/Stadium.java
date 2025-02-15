package racingcar.domain.stadium;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.view.OutputView;

public class Stadium {
  private  StadiumState state;
  private final StadiumService service;

  public Stadium() {
    this.state = new StadiumState();
    this.service = new StadiumService();
  }

  public StadiumState getState() {

    return new StadiumState(this.state);
  }

  public void addCars(String[] cars) {
    for (int i = 0; i < cars.length; i++) {
      this.state.addCar(new Car(cars[i]));
    }
  }

  public void startGame(int attemptCount) {

    for (int i = 0; i < attemptCount; i++) {
      runAttempt();
    }
    List<String> winners = getWinner();

    OutputView.printWinner(winners);
  }

  private void runAttempt() {
    service.runAttempts(state.cars);
  }

  private List<String> getWinner() {

    List<Car> cars = this.state.cars;

    return service.findLeadingCar(cars);
  }
}

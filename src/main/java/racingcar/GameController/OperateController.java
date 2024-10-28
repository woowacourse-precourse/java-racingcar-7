package racingcar.GameController;

import java.util.List;
import racingcar.Input.NameInput;
import racingcar.Manager.CarListManager;
import racingcar.Vehicle.Car;

public class OperateController {

  private List<Car> carList;

  public OperateController(NameInput nameInput, int gameRound) {
    GiveCommandToCarListManager(nameInput, gameRound);
  }

  public void GiveCommandToCarListManager(NameInput nameInput, int gameRound) {
    CarListManager carListManager = new CarListManager(nameInput);
    carListManager.makeCarList();
    for (int i = 0; i < gameRound; i++) {
      carListManager.sendRequestForAll();
    }
    this.carList = carListManager.getCarList();
  }

  public List<Car> getCarList() {
    return this.carList;
  }
}

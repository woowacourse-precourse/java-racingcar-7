package racingcar.GameController;

import java.util.List;
import racingcar.ReturnResult;
import racingcar.Vehicle.Car;

public class GameController {


  public List<Car> carList;


  public GameController() {
    GameStart();
    printResult();
  }

  private void GameStart() {
    InputController inputController = new InputController();
    this.carList = new OperateController(inputController.getNameInput(),
        inputController.getGameRound()).getCarList();
  }

  public void printResult() {
    ReturnResult returnResult = new ReturnResult(this.carList);
    returnResult.printWinners(returnResult.getTopCars());
  }
}

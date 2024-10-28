package racingcar.GameController;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Input.GameRoundInput;
import racingcar.Input.NameInput;
import racingcar.Manager.CarListManager;
import racingcar.ReturnResult;
import racingcar.Vehicle.Car;

public class GameController{

  public int GameRound;

  public NameInput nameInput;

  public List<Car> carList;

  public GameController() {
    getInput();
    GiveCommandToCarListManager();
    printResult();
  }

  public void getInput(){
    getNameInput();
    getGameRoundInput();
  }


  public void getNameInput(){
    NameInput nameInput = new NameInput();
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String names = Console.readLine();
    if(nameInput.validateInput(names)){
      nameInput.setName(names);
    }else{
      throw new IllegalArgumentException();
    }
    this.nameInput = nameInput;
  }

  public void getGameRoundInput(){
    GameRoundInput GameRound = new GameRoundInput();
    System.out.println("시도할 횟수는 몇 회인가요?");
    GameRound.setGameRound(Integer.parseInt(Console.readLine()));
    this.GameRound = GameRound.getGameRound();
  }

  public void GiveCommandToCarListManager(){
    CarListManager carListManager = new CarListManager(this.nameInput);
    carListManager.makeCarList();
    for(int i = 0; i < this.GameRound; i++){
      carListManager.sendRequestForAll();
    }
    this.carList = carListManager.getCarList();
  }

  public void printResult(){
    ReturnResult returnResult = new ReturnResult(this.carList);
    returnResult.printWinners(returnResult.getTopCars());
  }
}

package racingcar.Manager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Input.NameInput;
import racingcar.Vehicle.Car;

public class CarListManager {


  private List<Car> carList = new ArrayList<>();
  private NameInput nameInput;

  public CarListManager(NameInput nameInput) {
    this.nameInput = nameInput;
  }

  public void makeCarList(){
    String[] carNames = nameInput.getName();
    for(String carName : carNames)
    {
      this.carList.add(new Car(carName,0));
    }
  }

  public int makeRandomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }
  public void makeRequest(Car car) {
    if(makeRandomNumber() >= 4) {
      car.updateMove();
    }
  }

  public void sendRequestForAll()
  {
    for(Car car : this.carList)
    {
      makeRequest(car);
      car.printStatus();
    }
    System.out.println();
  }

  public List<Car> getCarList()
  {
    return this.carList;
  }
}

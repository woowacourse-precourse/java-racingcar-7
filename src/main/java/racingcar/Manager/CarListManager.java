package racingcar.Manager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.Input.MoveCountInput;
import racingcar.Input.NameInput;
import racingcar.Vehicle.Car;

public class CarListManager {


  private List<Car> CarList;
  private MoveCountInput mc;
  private NameInput ni;

  public CarListManager(MoveCountInput mc , NameInput ni) {
    this.mc = mc;
    this.ni = ni;
  }

  public int makeRandomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }

  public void sendRequestForAll()
  {
    for(Car car : this.CarList)
    {
      makeRequest(car);
    }
  }

  public void makeRequest(Car car) {
    if(makeRandomNumber() >= 4) {
      car.updateMove();
    }
  }

  public void makeCarList(){
    String[] carNames = ni.getInput();
    for(String carName : carNames)
    {
      Car car = new Car(carName,0);
      CarList.add(car);
    }
  }


}

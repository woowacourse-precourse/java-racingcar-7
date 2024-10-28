package racingcar;

public abstract class CarInfo {
     protected String carName;
     protected int carPosition = 0;

     public CarInfo(String carName) {
          this.carName = carName;
     }
}

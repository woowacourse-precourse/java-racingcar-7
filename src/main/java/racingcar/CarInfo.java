package racingcar;

public abstract class CarInfo {
     protected String carName;
     protected int carPosition = 0;

     public CarInfo(String carName) {
          this.carName = carName;
     }

     public void carMove() {
          carPosition++;
     }

     public String getCarName() {
          return carName;
     }

     public int getCarPosition() {
          return carPosition;
     }
}

class Car extends CarInfo {
     public Car(String carName) {
          super(carName);
     }
}
package racingcar;

public class Application {
  public static void main(String[] args) {
    CarRace carRace = new CarRace();
    String[] carName = Input.carName();
    int count = Input.count();
    carRace.startRace(carName, count);
  }
}
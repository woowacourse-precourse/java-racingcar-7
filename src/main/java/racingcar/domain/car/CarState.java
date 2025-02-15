package racingcar.domain.car;


public class CarState  {
  public final String name;
  public final  int position;

  public CarState(CarState carState){
    this.name = carState.name;
    this.position = carState.position;
  }

  public CarState(String name, int position) {
    this.name = name;
    this.position = position;
  }
  public CarState(String name) {
    this(name, 0);
  }

}

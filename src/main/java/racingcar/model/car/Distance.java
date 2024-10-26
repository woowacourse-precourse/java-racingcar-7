package racingcar.model.car;

public class Distance {

  private final String distanceShape = "-";

  private StringBuilder distance;

  public Distance() {
    distance = new StringBuilder();
  }

  public void increaseDistance(){
    distance.append(distanceShape);
  }


}

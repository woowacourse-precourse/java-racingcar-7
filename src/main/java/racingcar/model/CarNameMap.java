package racingcar.model;

import java.util.HashMap;
import java.util.List;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public record CarNameMap(
    HashMap<String, Car> map
) {

  public static CarNameMap from(List<Car> cars) {
    HashMap<String, Car> map = new HashMap<>();
    for (Car car : cars){
      map.put(car.getName(), car);
    }
    return new CarNameMap(map);
  }
}

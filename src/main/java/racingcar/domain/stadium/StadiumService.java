package racingcar.domain.stadium;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarState;
import racingcar.view.OutputView;

public class StadiumService {

  public void runAttempts(List<Car> cars) {

    OutputView.printSeparator();
    for (Car car : cars) {
      car.stepForward();
      CarState state = car.getState();

      OutputView.printCarPosition(state.name, state.position);
    }
  }

  public List<String> findLeadingCar(List<Car> cars) {
    List<Car> SortedCars = cars.stream().sorted(Car.positionComparatorDesc).toList();
    int carsLength = SortedCars.size();
    int maxPosition = SortedCars.get(0).getPosition();
    List<String> result = new ArrayList<>();

    for (int i = 0; i < carsLength; i++) {
      Car currentCar = SortedCars.get(i);
      if (currentCar.getPosition() >= maxPosition) {
        result.add(currentCar.getName());
      }
    }
    return result;
  }
}

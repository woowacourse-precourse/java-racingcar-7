package racingcar.view;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class OutputView {
    private static final String StartOutputMessage = "실행 결과";

    public static void startOutput(){
      System.out.println(StartOutputMessage);
    }

    public static void printCarRacingStatus(Cars cars){
        for (Car car : cars.getCars()) {
          System.out.println(toStringCarResult(car));
        }
    }

    private static String toStringCarResult(Car car){
      return car.getName().getName() + " : " + car.getDistance().toString();
    }

}

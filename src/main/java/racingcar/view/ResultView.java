package racingcar.view;


import java.util.List;
import racingcar.model.Car;


public class ResultView {
   public static void printRaceResult(List<Car> cars) {
       for (Car car : cars) {
           System.out.println(car.getName() + " : " + "-".repeat(car.getPosition().intValue()));
       }
       System.out.println();
   }


   public static void printWinners(List<Car> winners) {
   }
  
}

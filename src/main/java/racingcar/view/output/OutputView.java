package racingcar.view.output;

import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.view.output.dto.RacingResponse;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public class OutputView {
  private static final String EXECUTE_RESULT = "실행 결과";
  private static final String WINNER_PREFIX = "최종 우승자 : ";
  private static final String WINNER_DELIMITER = ", ";
  private static final String SEPARATOR = " : ";
  private static final String POSITION_COUNTER = "-";

  public static void printExecuteResult(){
    System.out.println(EXECUTE_RESULT);
  }

  private static void printCarStatus(Car car) {
    StringBuilder stringBuilder = new StringBuilder(
        car.getName())
        .append(SEPARATOR)
        .append(POSITION_COUNTER.repeat(car.getPosition()));
    System.out.println(stringBuilder);
  }

  public static void printRoundResult(List<Car> cars){
    for (Car car : cars){
      printCarStatus(car);
    }
    System.out.println();
  }

  public static void printRoundResult(Map<String, Car> carNameMap, List<String> carNames){
    for (String carName : carNames){
      printCarStatus(carNameMap.get(carName));
    }
  }

  public static void printRacingResult(RacingResponse racingResponse){
    System.out.println(WINNER_PREFIX + String.join(WINNER_DELIMITER, racingResponse.winners()));
  }

}

package racingcar.view.output;

import java.util.List;
import racingcar.view.input.dto.RacingRequest;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public class OutputView {
  private static final String WINNER_PREFIX = "최종 우승자 : ";
  private static final String WINNER_DELIMITER = ", ";

  public static void printRacingResult(List<String> winnerNames){
    System.out.println(WINNER_PREFIX + String.join(WINNER_DELIMITER, winnerNames));
  }

}

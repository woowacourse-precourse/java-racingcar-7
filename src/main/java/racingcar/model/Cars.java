package racingcar.model;

import java.util.List;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public interface Cars {
  List<Car> findCarsByPosition(int position);
  int findMaxPosition();
  List<Car> getWinners ();
  List<Car> getList();
  RacingRoundResult moveOrStayAll();
}

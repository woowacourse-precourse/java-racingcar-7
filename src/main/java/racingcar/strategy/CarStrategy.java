package racingcar.strategy;

import java.util.List;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public interface CarStrategy {
  List<String> splitNames(String rawCarNames);
  void validateNames(List<String> splitNames);
}

package racingcar.strategy;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public interface CarStrategy {
  String[] splitNames(String rawCarNames);
  void validateNames(String[] splitNames);
}

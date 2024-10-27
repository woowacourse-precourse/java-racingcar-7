package racingcar.strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.common.exception.dto.ExceptionEnum;
import racingcar.service.car.exception.CarException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class CarBasicStrategy implements CarStrategy{
  private static final String DELIMITER = ",";
  private static final int MAXIMUM_NAME_LENGTH = 5;

  @Override
  public List<String> splitNames(String rawCarNames){
    return Arrays.stream(rawCarNames.split(DELIMITER))
        .toList();
  }

  @Override
  public void validateNames(List<String> splitNames){
    Set<String> uniqueNames = new HashSet<>();
    for (String name : splitNames){
      validateSingleName(name, uniqueNames);
      uniqueNames.add(name);
    }
  }

  private void validateUniqueName(String name, Set<String> uniqueNames){
    if (uniqueNames.contains(name)){
      throw new CarException(ExceptionEnum.DUPLICATE_CAR_NAME, name);
    }
  }

  private void validateNameLength(String name){
    if (name.length() > MAXIMUM_NAME_LENGTH){
      throw new CarException(ExceptionEnum.CAR_NAME_LONGGER_THAN_FIVE, name);
    }
  }

  private void validateSingleName(String name, Set<String> uniqueNames){
    validateNameLength(name);
    validateUniqueName(name, uniqueNames);
  }
}

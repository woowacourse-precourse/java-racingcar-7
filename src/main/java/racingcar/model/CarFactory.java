package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
  private static final String regex = "(.*[.@].*|.*,,.*|.*,.[.@].*)";

  public List<Car> extractCarNames(String input) {
    validateCarNameByComma(input);
    List<Car> extractedCars = Arrays.stream(input.split(","))
            .map(String::trim)
            .peek(this::validateCarNameLength)
            .peek(this::validateCarNameIsEmpty)
            .map(Car::new)
            .toList();
    validateCarNamesCount(extractedCars);
    validateDuplicateCarNames(extractedCars);
    return extractedCars;
  }

  private void validateCarNameByComma(String input) {
    if (input.matches(regex)) throw new IllegalArgumentException("자동차 이름은 쉼표로만 구분되며, 명확한 형식을 유지해야 합니다.");
  }

  private void validateCarNameLength(String carName) {
    if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
  }

  private void validateCarNameIsEmpty(String carName) {
    if (carName.isEmpty()) throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
  }

  private void validateCarNamesCount(List<Car> extractedCars) {
    if (extractedCars.size() < 2) throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
  }

  private void validateDuplicateCarNames(List<Car> extractedCars) {
    if (extractedCars.stream().map(Car::getCarName).distinct().count() != extractedCars.size()) {
      throw new IllegalArgumentException("중복된 자동차 이름은 허용되지 않습니다.");
    }
  }
}

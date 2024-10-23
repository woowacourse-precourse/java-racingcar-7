package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class Cars {

  private final List<String> cars;
  private static final String regex = "(.*[.@].*|.*,,.*|.*,.[.@].*)";

  public Cars(String input) {
    this.cars = extractCarNames(input);
  }

  public List<String> getCars() {
    return cars;
  }

  private List<String> extractCarNames(String input) {
    validateCarNameByComma(input);
    List<String> extractedCars = Arrays.stream(input.split(","))
            .peek(this::validateCarNameLength)
            .peek(this::validateCarNameIsEmpty).toList();
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

  private void validateCarNamesCount(List<String> extractedCars) {
    if (extractedCars.size() < 2) throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
  }

  private void validateDuplicateCarNames(List<String> extractedCars) {
    if (extractedCars.size() != extractedCars.stream().distinct().count()) {
      throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
    }
  }
}

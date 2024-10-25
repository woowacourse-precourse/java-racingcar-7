package racingcar.domain;

public class GameCount {
  private final int count;

  public GameCount(String input) {
    this.count = validateAndParse(input);
  }

  private int validateAndParse(String input) {
    if (input == null) {
      throw new IllegalArgumentException("Error: 입력값이 null일 수 없습니다.");
    }
    if (input.trim().isEmpty()) {
      throw new IllegalArgumentException("Error: 시도 횟수는 비어있을 수 없습니다.");
    }

    try {
      int parsedValue = Integer.parseInt(input);
      if (parsedValue < 1) {
        throw new IllegalArgumentException("Error: 시도 횟수는 1 이상의 값이어야 합니다.");
      }
      return parsedValue;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Error: 시도 횟수는 1 이상 2,147,483,647 이하의 정수여야 합니다.");
    }
  }

  public int getCount() {
    return count;
  }

}

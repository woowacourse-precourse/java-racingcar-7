package racingcar.error;

public class ErrorMessages {

  // 자동차 관련 에러 메시지
  public static final String CAR_NAME_EMPTY = "Error: 자동차 이름은 비어있을 수 없습니다.";
  public static final String CAR_NAME_TOO_LONG = "Error: 자동차 이름은 5자 이하로 입력해야 합니다.";
  public static final String CAR_NAME_DUPLICATE = "Error: 중복된 자동차 이름은 허용되지 않습니다.";

  // 입력값 관련 에러 메시지
  public static final String INPUT_NULL = "Error: 입력값이 null일 수 없습니다.";
  public static final String INPUT_EMPTY = "Error: 입력값은 비어있을 수 없습니다.";

  // 시도 횟수 관련 에러 메시지
  public static final String GAME_COUNT_EMPTY = "Error: 시도 횟수는 비어있을 수 없습니다.";
  public static final String GAME_COUNT_INVALID = "Error: 시도 횟수는 1 이상의 값이어야 합니다.";
  public static final String GAME_COUNT_FORMAT_ERROR = "Error: 시도 횟수는 1 이상 2,147,483,647 이하의 정수여야 합니다.";

  private ErrorMessages() {

  }
}

package racingcar.util;

public class Constants {

  private Constants() {
  }

  public static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  public static final String GAME_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
  public static final String GAME_START_MESSAGE = "\n실행 결과";
  public static final String WINNERS_MESSAGE_PREFIX = "최종 우승자 : ";
  public static final String JOIN_DELIMITER = ", ";
  public static final int MAX_CAR_NAME_LENGTH = 5;
  public static final String CAR_NAME_DELIMITER = ",";
  public static final int MIN_RANDOM_VALUE = 0;
  public static final int MAX_RANDOM_VALUE = 9;
  public static final int MOVABLE_THRESHOLD = 4;
  public static final int MIN_GAME_COUNT = 1;
  public static final int CAN_NOT_PLAY_COUNT = 0;
}

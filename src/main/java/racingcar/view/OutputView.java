package racingcar.view;

import java.util.List;

public class OutputView {

  private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String GAME_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
  private static final String GAME_START_MESSAGE = "\n실행 결과";
  private static final String WINNERS_MESSAGE_PREFIX = "최종 우승자 : ";

  private OutputView() {
  }

  public static void printCarNamePrompt() {
    System.out.println(CAR_NAME_PROMPT);
  }

  public static void printGameCountPrompt() {
    System.out.println(GAME_COUNT_PROMPT);
  }

  public static void printGameStartMessage() {
    System.out.println(GAME_START_MESSAGE);
  }

  public static void printCarPositions(List<String> carStatuses) {
    carStatuses.forEach(System.out::println);
    System.out.println();
  }

  public static void printWinners(List<String> winners) {
    System.out.println(WINNERS_MESSAGE_PREFIX + String.join(", ", winners));
  }
}

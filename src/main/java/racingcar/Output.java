package racingcar;

import java.util.List;

public class Output {
  public static void showRound(RoundStatus roundStatus) {
    System.out.println("라운드 " + (roundStatus.getRound()));
    for (CarStatus carStatus : roundStatus.getCarStatusList()) {
      System.out.println(carStatus.getName() + " : " + "-".repeat(carStatus.getPosition()));
    }
    System.out.println();
  }

  public static void showWinner(WinnerStatus winnerStatus) {
    List<String> winners = winnerStatus.getWinners();
    System.out.println("최종 우승자 : " + String.join(", ", winners));
  }
}

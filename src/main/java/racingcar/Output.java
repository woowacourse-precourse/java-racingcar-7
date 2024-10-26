package racingcar;

public class Output {
  public static void showRound(RoundStatus roundStatus) {
    System.out.println("라운드 " + (roundStatus.getRound()));
    for (CarStatus carStatus : roundStatus.getCarStatusList()) {
      System.out.println(carStatus.getName() + " : " + "-".repeat(carStatus.getPosition()));
    }
    System.out.println();
  }

  public static void showWinner(String winner){
    System.out.println("최종 우승자 : " + winner);
  }
}

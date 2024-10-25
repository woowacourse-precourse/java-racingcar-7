package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class CarGame {

  public  int carRun() {
    return Randoms.pickNumberInRange(0, 9);
  }

  public void getGameSituation(Map<String, String> carGameRecords) {
    for (Map.Entry<String, String> carsRecords : carGameRecords.entrySet()) {
      String result = carsRecords.getKey() + " : ";
      String forward = "-";
      String gameSituation = carsRecords.getValue();
      if (carRun() >= 4) {
        gameSituation += forward;
        carGameRecords.put(carsRecords.getKey(), gameSituation);
        result = result + gameSituation;
      }
      System.out.println(result);
    }

  }

  public void showGame(Map<String, String> carGameRecords, int frequency) {
    System.out.println("실행 결과");
    for (int i = 0; i < frequency; i++) {
      getGameSituation(carGameRecords);
      System.out.println("\n");
    }
  }
}

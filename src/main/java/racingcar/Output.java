package racingcar;

import java.util.HashMap;

public class Output {
  public static void raceResult(String[] carName, HashMap<Integer, Integer> carList, int bestScore) {
    StringBuilder sb = new StringBuilder();
    sb.append("최종 우승자 : ");
    for (int i = 0; i < carName.length; i++) {
      if (carList.get(i) >= bestScore) {
        sb.append(carName[i]);
        sb.append(", ");
      }
    }
    sb.delete(sb.length() - 2, sb.length());
    System.out.println(sb);
  }
}
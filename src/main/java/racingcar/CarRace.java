package racingcar;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRace {
  public void startRace(String[] carName, int count) {
    HashMap<Integer, Integer> carList = new HashMap<>();
    int bestScore = 0;
    for (int i = 0; i < carName.length; i++) {
      carList.put(i, 0); // 초기값 세팅
    }
    System.out.println();
    if (count != 0) {
      System.out.println("실행 결과");
      for (int i = 0; i < count; i++) {
        bestScore = Math.max(currentRound(carName, carList), bestScore); // 순차별 진행
      }
    }
    Output.raceResult(carName, carList, bestScore); // 최종 결과 호출
  }

  private int currentRound(String[] carName, HashMap<Integer, Integer> carList) {
    int roundBestScore = -1;
    for (int i = 0; i < carList.size(); i++) {
      if (Randoms.pickNumberInRange(0, 9) >= 4) {
        carList.put(i, carList.getOrDefault(i, 0) + 1); // 랜덤함수를 사용하여 4 이상이면 1을 더한다.
      }
      System.out.println(carName[i] + " : " + "-".repeat(carList.get(i)));
      roundBestScore = Math.max(roundBestScore, carList.get(i)); //  순차별로 최댓값을 집계한다.
    }
    System.out.println();
    return roundBestScore;
  }
}
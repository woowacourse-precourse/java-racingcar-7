package racingcar;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Randoms;

public class CarRace {
  public void startRace(String[] carName, int count){
    if(count == 0){
      // count가 0이면 공동우승으로 처리
    }
    HashMap<Integer, Integer> carList = new HashMap<>();
    for(int i = 0; i<carName.length; i++){
      carList.put(i,0); // 초기값 세팅
    }
    System.out.println("\n실행 결과");
    for(int i = 0; i<count; i++){
      currentRound(carName, carList); // 순차별 진행
    }
    // 최종 결과 집계
    // 순차별 진행을 통해서 최댓값을 저장하고 아웃풋으로 같이 보낸다.
  }

  private void currentRound(String[] carName, HashMap<Integer, Integer> carList){
    for(int i = 0; i<carList.size(); i++){
      if(Randoms.pickNumberInRange(0,9) >= 4){
        carList.put(i,carList.getOrDefault(i,carList.get(i))+1); // 랜덤함수를 사용하여 4 이상이면 1을 더한다.
      }
      System.out.println(carName[i]+" : "+"-".repeat(carList.get(i)));
    }
    System.out.println();
  }
}
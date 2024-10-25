package racingcar.view.io;

import java.util.List;
import java.util.Map;

public class Output {
    //실행 결과 출력을 여기다 추가해야 하나?

    public void gameResult(Map<String, Integer> carMap) {
        for (String key : carMap.keySet()) {
            System.out.print(key + " : ");
            for (int i = 0; i < carMap.get(key); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void winner(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (i != winnerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}

package racingcar.io;

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
    }

    public void winner() {

    }
}

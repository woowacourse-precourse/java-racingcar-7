package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private final LinkedHashMap<String, Integer> carNameAndScore;
    private final int tryCount;

    public RacingGame(LinkedHashMap<String, Integer> carScore) {
        this.carNameAndScore = CarInformation.getCarInformation();
        this.tryCount = Input.inputTryCount(); // 시도 횟수를 Input 클래스에서 입력받음
    }

    public void randomMove() {
        for (int i = 0; i < tryCount; i++) {
            for (String car : carNameAndScore.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);

                if (randomNumber >= 4) {
                    carNameAndScore.put(car, carNameAndScore.get(car) + 1);
                }
            }
            printResult();
        }
    }

    private void printResult() {
        for(Map.Entry<String, Integer> entry : carNameAndScore.entrySet()) {
            System.out.println(entry.getKey() + " : ");
            for(int i=0;i<entry.getValue();i++) {
                System.out.println("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printWinner() {
        int maxScore = Collections.max(carNameAndScore.values());

        List<String> winners = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : carNameAndScore.entrySet()) {
            if(entry.getValue() == maxScore) {
                winners.add(entry.getKey());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

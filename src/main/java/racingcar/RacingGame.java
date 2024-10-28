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

    public RacingGame(LinkedHashMap<String, Integer> carNameAndScore, int tryCount) {
        this.carNameAndScore = carNameAndScore;
        this.tryCount = tryCount;
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void randomMove() {
        for (int i = 0; i < tryCount; i++) {
            for (String car : carNameAndScore.keySet()) {
                int randomNumber = getRandomNumber();

                if (randomNumber >= 4) {
                    carNameAndScore.put(car, carNameAndScore.get(car) + 1);
                }
            }
            printResult();
        }
    }

    private void printResult() {
        for (Map.Entry<String, Integer> entry : carNameAndScore.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<String> printWinner() {
        int maxScore = Collections.max(carNameAndScore.values());

        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carNameAndScore.entrySet()) {
            if (entry.getValue() == maxScore) {
                winners.add(entry.getKey());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
        return winners;
    }
}

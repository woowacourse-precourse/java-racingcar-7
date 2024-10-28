package racingcar.caculator;

import racingcar.output.WinnerOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDistance {

    private final WinnerOutput winnerOutput = new WinnerOutput();

    // 자동차 거리 계산 및 출력
    public void CarDistanceCaculator(List<String> carName, List<String> totalWinners) {
        Map<String, Integer> carDistances = new HashMap<>();

        // totalWinners를 순회하여 각 자동차의 이동 거리를 세기
        for (String winner : totalWinners) {
            carDistances.put(winner, carDistances.getOrDefault(winner, 0) + 1);
        }

        List<String> carList = carName;

        // 자동차별로 이동 거리 출력
        for (String car : carList) {
            System.out.print(car + " : ");
            int distance = carDistances.getOrDefault(car, 0);// 기본값은 0

            // '-' 출력
            for (int j = 0; j < distance; j++) {
                System.out.print("-");
            }

            // 줄바꿈
            System.out.println();
        }
    }
}

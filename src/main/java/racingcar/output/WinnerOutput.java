package racingcar.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerOutput {
    public void FinallyWinner(List<String> totalWinners) {
        // 최종 우승자를 추출하는 메서드
        Map<String, Integer> winCount = new HashMap<>();

        // 각 자동차의 우승 횟수를 기록
        for (String winner : totalWinners) {
            winCount.put(winner, winCount.getOrDefault(winner, 0) + 1);
        }

        // 최대 우승 횟수를 찾기
        int maxWins = Integer.MIN_VALUE;
        for (int wins : winCount.values()) {
            if (wins > maxWins) {
                maxWins = wins;
            }
        }

        // 최대 우승 횟수와 동일한 우승자들 추출
        List<String> finalWinners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : winCount.entrySet()) {
            if (entry.getValue() == maxWins) {
                finalWinners.add(entry.getKey());
            }
        }

        // 최종 우승자를 출력
        System.out.println("최종 우승자 : " + String.join(", ", finalWinners));
    }
}
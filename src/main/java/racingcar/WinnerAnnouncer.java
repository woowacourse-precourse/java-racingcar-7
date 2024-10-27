package racingcar;

import java.util.*;

public class WinnerAnnouncer {
    public void announceWinners(Map<String, Integer> carPositions) {
        List<String> winners = new ArrayList<>();
        int maxPosition = Collections.max(carPositions.values());

        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            if (entry.getValue() == maxPosition) {
                winners.add(entry.getKey());
            }
        }

        // 우승자 발표
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst());
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }
}

package racingcar;

import java.util.*;

public class PrintWinner {
    public void printWinner(Map<String, Integer> carValues) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(carValues.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));  // 정렬했고
        Integer winnerScore = list.getFirst().getValue();
        Map<String, Integer> winners = new LinkedHashMap<>();  // 순서있는 HashMap 만들어서
        for (var entry : list) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (winnerScore.equals(value))
                winners.put(entry.getKey(), entry.getValue());
        }
        var result = String.join(", ", winners.keySet());
        System.out.println("최종 우승자 : " + result);
    }
}

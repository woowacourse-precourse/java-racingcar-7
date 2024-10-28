package racingcar;

import java.util.*;

public class PrintWinner {
    public void winnerPrint(Map<String, Integer> carValues) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(carValues.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        Integer winnerScore = list.getFirst().getValue();
        Map<String, Integer> winners = new LinkedHashMap<>();
        for (var entry : list) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (winnerScore.equals(value))
                winners.put(key, value);
        }
        var result = String.join(", ", winners.keySet());
        System.out.println("최종 우승자 : " + result);
    }
}

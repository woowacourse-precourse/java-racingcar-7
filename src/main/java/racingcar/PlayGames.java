package racingcar;

import java.util.Map;

public class PlayGames {
    public Map<String, Integer> RepetitionGames(int count, Map<String, Integer> carValues) {
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (Map.Entry<String, Integer> entry : carValues.entrySet()) {
                String car = entry.getKey();
                Integer value = entry.getValue();

                GoOrStop goOrStop = new GoOrStop();
                goOrStop.decisionGo(entry);
            }
            System.out.println();
        }
        return carValues;
    }
}

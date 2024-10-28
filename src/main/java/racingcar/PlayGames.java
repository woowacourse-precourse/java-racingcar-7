package racingcar;

import java.util.Map;

public class PlayGames {
    public Map<String, Integer> repetitionGames(Map<String, Integer> carValues, int count) {
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (Map.Entry<String, Integer> entry : carValues.entrySet()) {
                GoOrStop goOrStop = new GoOrStop();
                goOrStop.decisionGo(entry);
            }
            System.out.println();
        }
        return carValues;
    }
}

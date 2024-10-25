package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {

    public static Map<String, Integer> convertStringToMap(final String car_nameList) {
        String INPUT_DELIMITER = ",";

        String[] cars = car_nameList.split(INPUT_DELIMITER);

        Map<String, Integer> raceScores = new HashMap<>();

        for (String car_name : cars) {
            raceScores.put(car_name.trim(), 0);  //  trim()으로 불필요한 공백 제거
        }
        return raceScores;
    }

    public static void race(final Map<String, Integer> raceScores)
    {
        for (String car_name : raceScores.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                raceScores.put(car_name, raceScores.get(car_name) + 1);
            }
            System.out.println(car_name + ": " + "-".repeat(raceScores.get(car_name)));
        }
        //각 출력마다 공백 넣기
        System.out.println();
    }

    public static String winner(final Map<String, Integer> raceScores) {
        List<String> highestScorers = new ArrayList<>();
        int highestScore = Integer.MIN_VALUE; // 초기값을 매우 낮은 점수로 설정

        for (Map.Entry<String, Integer> entry : raceScores.entrySet()) {
            if (entry.getValue() > highestScore) {
                highestScore = entry.getValue();
                highestScorers.clear();
                highestScorers.add(entry.getKey());
            }
            else if (entry.getValue() == highestScore) {
                highestScorers.add(entry.getKey());
            }
        }

        String result = String.join(", ", highestScorers);

        return result;
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    public static void race(String car, String number) {
        List<String> names = Arrays.asList(car.split(","));

        for (String playerName : names) {
            if (playerName.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }

        int n = Integer.parseInt(number);

        Map<String, Integer> map2 = new HashMap<>();
        for (String playerName : names) {
            map2.put(playerName, 0);
        }
        // 경주 진행
        for (int i = 0; i < n; i++) {
            for (String playerName : names) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    map2.put(playerName, map2.get(playerName) + 1);
                }
            }

            System.out.println("실행 결과");
            for (String playerName : names) {
                int score = map2.get(playerName);
                String dashes = "-".repeat(score);
                System.out.println(playerName.trim() + " : " + dashes);
            }
            System.out.println();
        }

        // 우승자 결정하기
        List<String> highestScorer = new ArrayList<>();
        int highestScore = -1;

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() > highestScore) {
                highestScore = entry.getValue();
                highestScorer.clear();
                highestScorer.add(entry.getKey());
            } else if (entry.getValue() == highestScore) {
                highestScorer.add(entry.getKey());
            }
        }

        if (highestScorer != null) {
            System.out.println("최종 우승자 : " + String.join(", ", highestScorer));
        } else {
            System.out.println("참가자가 없습니다.");
        }
    }

}


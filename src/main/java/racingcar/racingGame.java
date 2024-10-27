package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class racingGame {
    HashMap<String, Integer> race = new HashMap<>();

    public void run(InputResult inputResult) {
        System.out.println("실행 결과");

        String[] carNames = inputResult.carNames;
        int tryNum = inputResult.tryNum;

        for (String name : carNames) {
            race.put(name, 0); // value값 초기화해서 npe 처리
        }

        // 조건에 따라 전진/멈춤
        for (int i = 0; i < tryNum; i++) {
            for (String carName : carNames) {
                int raceCnt = race.get(carName);

                int random = Randoms.pickNumberInRange(0, 9);
                if (random < 4) {
                    System.out.println(carName + " : " + "-".repeat(raceCnt));
                } else {
                    raceCnt++;
                    race.put(carName, raceCnt); // 상태 저장
                    System.out.println(carName + " : " + "-".repeat(raceCnt));
                }
            }
            System.out.println();
        }

        // 최댓값 구해서 이름 출력하기
        Integer maxValue = Collections.max(race.values());
        ArrayList<String> winners = new ArrayList<>();

        for (String carName : carNames) {
            if (Objects.equals(maxValue, race.get(carName))) {
                winners.add(carName);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}

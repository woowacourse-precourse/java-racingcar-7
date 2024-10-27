package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class racingGame {
    HashMap<String, Integer> race;
    ConditionConfig condConfig;

    racingGame(ConditionConfig condConfig) {
        this.race = new HashMap<>();
        this.condConfig = condConfig;
    }

    public void run(InputResult inputResult) {
        System.out.println("실행 결과");

        String[] carNames = inputResult.carNames;
        int tryNum = inputResult.tryNum;

        for (String name : carNames) {
            race.put(name, 0);
        }

        for (int i = 0; i < tryNum; i++) {
            for (String carName : carNames) {
                execute(carName);
            }
            System.out.println();
        }

        ArrayList<String> winners = findMax(carNames);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    // 경계값 이상일때(true) 전진
    private void moveForward(String carName, int step) {
        int moveCnt = race.get(carName);
        race.put(carName, moveCnt + step); // 추후 바뀔 리터럴 고려
    }

    // 난수 생성해서 조건에 따라 진행
    private boolean goOrStop() {
        int random = Randoms.pickNumberInRange(condConfig.rand_min, condConfig.rand_max);
        return random >= condConfig.threshold;
    }

    private void execute(String carName) {
        boolean go = goOrStop();
        if (go) {
            moveForward(carName, 1);
        }

        int moveCnt = race.get(carName);
        System.out.println(carName + " : " + "-".repeat(moveCnt));
    }

    private ArrayList<String> findMax(String[] carNames) {
        Integer maxValue = Collections.max(race.values());
        ArrayList<String> winners = new ArrayList<>();

        for (String carName : carNames) {
            if (Objects.equals(maxValue, race.get(carName))) {
                winners.add(carName);
            }
        }

        return winners;
    }
}

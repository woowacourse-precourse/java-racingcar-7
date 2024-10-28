package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class GoOrStop {
    public void decisionGo(Map.Entry<String, Integer> car) {
        System.out.print(car + " : ");
        int randomNum = Randoms.pickNumberInRange(0,9);
        if (randomNum >= 4) {
            car.setValue(car.getValue() + 1);
        }
        for (int i = 0; i < car.getValue(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingRoundService {

    public void racingRound() {
        int roundInNow = 0;

        System.out.println("실행 결과");
        while (roundInNow < racingRound) {
            for (String carName : racingCar.keySet()) {
                int randomDecisionNumber = pickNumberInRange(0,9);
                if (randomDecisionNumber > 3) {
                    //키가 가진 값이 하나 증가
                    int number = racingCar.get(carName);
                    racingCar.put(carName, number + 1);
                }
            }

            print(racingCar);
            roundInNow++;
        }
    }

}

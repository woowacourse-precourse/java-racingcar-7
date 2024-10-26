package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {
    List<String> nameOfCar = new ArrayList<>();
    List<Integer> randomNum = new ArrayList<>();
    List<Integer> movementNum = new ArrayList<>();

    public void separateCarNames (String namesOfCars) {
        nameOfCar = List.of(namesOfCars.split(","));
        for (String s : nameOfCar) { // movementNum 초기화
            movementNum.add(0);
        }
    }

    public void race (int numberOfRaces) {
        while (numberOfRaces > 0) {
            randomNum.clear();
            setRandomNum();
            decideStopOrGo();
            numberOfRaces--;
        }
    }

    public void setRandomNum () {
        for (int i=0; i<nameOfCar.size(); i++) {
            int num = Randoms.pickNumberInRange(0,9);
            randomNum.add(num);
        }
    }

    public void decideStopOrGo () {
        for (int i=0; i<randomNum.size(); i++) {
            if (randomNum.get(i) >= 4) {
                int increaseMovementNum = movementNum.get(i)+1;
                movementNum.set(i, increaseMovementNum);
            }
        }
    }
}

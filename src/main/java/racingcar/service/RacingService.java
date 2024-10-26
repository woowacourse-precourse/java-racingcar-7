package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {
    List<String> nameOfCar = new ArrayList<>();
    List<Integer> randomNum = new ArrayList<>();

    public void separateCarNames (String namesOfCars) {
        nameOfCar = List.of(namesOfCars.split(","));
    }

    public void race (int numberOfRaces) {
        while (numberOfRaces > 0) {
            randomNum.clear();
            setRandomNum();
            numberOfRaces--;
        }
    }

    public void setRandomNum () {
        for (int i=0; i<nameOfCar.size(); i++) {
            int num = Randoms.pickNumberInRange(0,9);
            randomNum.add(num);
        }
    }
}

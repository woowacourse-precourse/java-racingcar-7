package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    List<RacingCar> racingCars;

    public void init(List<String> carNames) {
        initCars(carNames);
    }

    public void initCars(List<String> carNames) {
        for (String name : carNames) {
            racingCars.add(RacingCar.createRacingCar(name));
        }
    }

    public Integer randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Boolean isForward(Integer number) {
        return number >= 4;
    }

    public Map<String, Integer> executeLogic(List<RacingCar> racingCars) {
        Map<String, Integer> result = new HashMap<>();
        for (RacingCar racingCar : racingCars) {
            Integer randomNumber = randomNumber();
            if (isForward(randomNumber)) {
                racingCar.addScore();
            }
            result.put(racingCar.getName(), randomNumber);
        }
        return result;
    }
}

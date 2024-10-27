package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class RacingCarService {

    public void race(List<String> carNameList, int tryCount) {
        List<Car> carList = carNameList.stream()
                .map(Car::new)
                .toList();
    }
}

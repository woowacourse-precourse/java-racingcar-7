package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class RandomGameService {
    public void RandomGame(List<Car> cars){
        for (Car car : cars) {
            int random= Randoms.pickNumberInRange(0,9);
            if (random>=4){
                car.addScore();
            }
        }
    }
}

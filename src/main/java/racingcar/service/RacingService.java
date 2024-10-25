package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.util.RandomUtil;

import java.util.List;

public class RacingService {
    private static final int MOVE_THRESHOLD =4;
    //전진 조건 확인 후 전진
    public void moveCars(List<Car> cars){
        for(Car car: cars){
            int randomValue = RandomUtil.generateRandomNumber();
            if(randomValue>MOVE_THRESHOLD){
                car.move();
            }
        }
    }
}

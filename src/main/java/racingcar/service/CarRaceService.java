package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class CarRaceService {
    public void performRaceRound(List<Car> cars) {
        for(Car car : cars) {
            goForward(car);
        }
    }

    private void goForward(Car car){
        if(isMovable()) {
            car.move();
        }
    }

    private boolean isMovable(){
        if(getRandomNumber() >= 4){
            return true;
        }
        return false;
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}

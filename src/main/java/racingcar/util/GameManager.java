package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.model.Car;

public class GameManager {

    public void playOneTime(ArrayList<Car> cars){
        for (Car car : cars){
            if(Randoms.pickNumberInRange(0, 9)>=4){
                car.plusDistance(1);
            }
        }
    }
}

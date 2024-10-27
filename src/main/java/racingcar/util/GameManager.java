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

    public ArrayList<Car> getWinner(ArrayList<Car> cars){
        ArrayList<Car> winners = new ArrayList<>();
        int max = -1;
        for (Car car : cars){
            if(max < car.getDistance()){
                winners.clear();
                max = car.getDistance();
                winners.add(car);
                continue;
            }
            if(max == car.getDistance()){
                winners.add(car);
            }
        }

        return winners;
    }
}

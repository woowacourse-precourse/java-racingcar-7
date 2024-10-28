package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RoundRace {
    public int randomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void playRound(List<Car> cars) {
        for(Car car : cars) {
            if(randomNumber() >= 4){
                car.moveForward();
            }
        }
    }
}

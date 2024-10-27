package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;

public class RoundRace {
    public int randomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void playRound(Car[] cars) {
        for(Car car : cars) {
            int random = randomNumber();

            if(random >= 4){
                car.moveForward();
            }
        }
    }
}

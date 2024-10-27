package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMover {
    public void moveCar(Car car){
        int randomValue = generateRandomNumber();
        if(randomValue >=4){
            car.move(randomValue);
        }
    }

    private int generateRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}

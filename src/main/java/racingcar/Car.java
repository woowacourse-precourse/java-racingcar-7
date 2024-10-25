package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4){
            position++;
        }
    }
}

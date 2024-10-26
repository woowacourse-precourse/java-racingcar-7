package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int mileage;

    public Car(String name){
        this.name = name;
        this.mileage = 0;
    }

    public int getMileage() {
        return mileage;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            mileage++;
        }
    }

}

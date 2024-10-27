package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int mileage;

    public Car(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
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

    @Override
    public String toString(){
        return name+" : "+ "-".repeat(mileage) + "\n";
    }

    public String getName(){
        return this.name;
    }

}

package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;
    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(){
        int randomInt = Randoms.pickNumberInRange(0, 9);
        if(randomInt >= 4){
            position ++;
        }
    }

}

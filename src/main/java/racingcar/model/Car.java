package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(){
        int random = Randoms.pickNumberInRange(0,9);
        if(random > 4){
            position++;
        }
    }
}

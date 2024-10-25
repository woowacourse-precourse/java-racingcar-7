package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int len;

    public Car(String name) {
        this.name = name;
    }

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4 && randomNumber <= 9){
            len++;
        }
    }

    public String getName(){
        return name;
    }
    public int getLen() {
        return len;
    }
}

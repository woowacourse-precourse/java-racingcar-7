package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int LIMIT = 4;
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0, 9) >= LIMIT ){
            distance++;
        }
    }

    public String getName(){
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
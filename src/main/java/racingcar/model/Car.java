package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private Integer distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public void moveForward(){
        if(isMoveForward()){
            this.distance++;
        }
    }

    private boolean isMoveForward(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}

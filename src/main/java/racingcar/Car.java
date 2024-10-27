package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public boolean judge (int random){
        return random >= 4;
    };
    public int random (){
        return Randoms.pickNumberInRange(0, 9);
    };

    public int getDistance(){
        return distance;
    }

    public void addDistance() {
        this.distance++;
    }
}

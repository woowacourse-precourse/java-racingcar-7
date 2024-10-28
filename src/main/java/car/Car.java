package car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static Integer maxDistance = 0;
    private final String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    private boolean canMove(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
    public void move(){
        if(!canMove()){
            return;
        }
        distance++;
        maxDistance = Math.max(distance, maxDistance);
    }

    public Integer getDistance(){
        return distance;
    }

    @Override
    public String toString(){
        return name + " : " + "-".repeat(distance);
    }
}
